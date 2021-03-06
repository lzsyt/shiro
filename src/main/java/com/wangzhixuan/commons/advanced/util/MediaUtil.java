package com.wangzhixuan.commons.advanced.util;

import com.wangzhixuan.commons.advanced.model.WeixinMedia;
import com.wangzhixuan.commons.util.CommonUtil;
import net.sf.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**  
*   
* 项目名称：wechatapi  
* 类名称：MediaUtil  
* 类描述：上传下载多媒体文件工具  
* 创建人：WQ  
* 创建时间：2014-3-8 下午7:55:34  
* @version       
*/
public class MediaUtil extends CommonUtil {
	/**
	 * 上传多媒体文件
	 * 
	 * @param accessToken 调用接口凭证
	 * @param type 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
	 * @param mediaFileUrl 媒体文件url(如：localhost:8080/test/upload/music.mp3)
	 * @return WeixinMedia
	 */
	public static WeixinMedia uploadMedia(String accessToken,
										  String type, String mediaFileUrl) {
		WeixinMedia weixinMedia=null;
		String uploadMediaUrl=UPLOAD_MEDIA_URL.replace("ACCESS_TOKEN", accessToken).replace("TYPE", type);
		
		//定义数据分隔符
		String boundary="------------7da2e536604c8";
		try {
			URL uploadUrl=new URL(uploadMediaUrl);
			HttpURLConnection uploadConn=(HttpURLConnection)uploadUrl.openConnection();
			uploadConn.setDoOutput(true);
			uploadConn.setDoInput(true);
			uploadConn.setRequestMethod("POST");
			// 设置请求头Content-Type
			uploadConn.setRequestProperty("Content-Type", "multipart/form-data;boundary="+boundary);
			// 获取媒体文件上传的输出流（往微信服务器写数据）
			OutputStream outputStream=uploadConn.getOutputStream();
			
			URL mediaUrl=new URL(mediaFileUrl);
			HttpURLConnection mediaConn=(HttpURLConnection) mediaUrl.openConnection();
			mediaConn.setDoOutput(true);
			mediaConn.setRequestMethod("GET");
			
			// 从请求头获取内容类型
			String contentType=mediaConn.getHeaderField("Content-Type");
			// 根据内容类型判断文件扩展名
			String fileExt=getFileExt(contentType);
			// 请求体开始
			outputStream.write(("--"+boundary+"\r\n").getBytes());
			outputStream.write(String.format("Content-Disposition: form-data; name=\"media\";filename=\"file1%s\"\r\n", fileExt).getBytes());
			outputStream.write(String.format("Content-Type: %s\r\n\r\n", contentType).getBytes());
			
			// 获取媒体文件的输入流(读取文件)
			BufferedInputStream bis=new BufferedInputStream(mediaConn.getInputStream());
			byte[] buf=new byte[8096];
			int size=0;
			while((size=bis.read(buf))!=-1){
				// 将媒体文件写到输出流（往微信服务器写数据）
				outputStream.write(buf,0,size);
			}
			
			// 请求体结束
			outputStream.write(("\r\n--"+boundary+"--\r\n").getBytes());
			outputStream.close();
			bis.close();
			mediaConn.disconnect();
			
			// 获取媒体文件上传的输入流（从微信服务器读数据）
			InputStream inputStream = uploadConn.getInputStream();
			InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"utf-8");
			BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
			StringBuffer buffer=new StringBuffer();
			String str=null;
			while ((str=bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream=null;
			uploadConn.disconnect();
			
			// 使用JSON-lib解析返回结果
			JSONObject jsonObject=JSONObject.fromObject(buffer.toString());
			System.err.println(jsonObject);
			weixinMedia=new WeixinMedia();
			weixinMedia.setType(jsonObject.getString("type"));
			// type等于thumb时的返回结果和其他类型不一样
			if ("thumb".equals(type)) {
				weixinMedia.setMediaId(jsonObject.getString("thumb_media_id"));
			}else {
				weixinMedia.setMediaId(jsonObject.getString("media_id"));
				weixinMedia.setCreatedAt(jsonObject.getInt("created_at"));
			}
		} catch (Exception e) {
			weixinMedia=null;
			log.error("上传媒体文件失败:{}",e);
		}
		return weixinMedia;
	}
	
	/**
	 * 下载多媒体文件
	 * 
	 * @param accessToken 调用接口凭证
	 * @param mediaId 媒体文件ID
	 * @param savePath 保存路径
	 * @return String 保存文件路径
	 */
	public static String getMedia(String accessToken,String mediaId,String savePath) {
		String filePath=null;
		String requestUrl=DOWNLOAD_MEDIA_URL.replace("ACCESS_TOKEN", 
				accessToken).replace("MEDIA_ID", mediaId);
		try {
			URL url=new URL(requestUrl);
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			conn.setDoInput(true);
			conn.setRequestMethod("GET");
			if (!savePath.endsWith("/")) {
				savePath +="/";
			}
			// 根据内容类型获取扩展名
			String fileExt=getFileExt(conn.getHeaderField("Content-Type"));
			// 将mediaId作为文件名
			filePath = savePath+mediaId+fileExt;
			
			BufferedInputStream bis=new BufferedInputStream(conn.getInputStream());
			FileOutputStream fos=new FileOutputStream(new File(filePath));
			byte[] buf=new byte[8096];
			int size=0;
			while ((size=bis.read(buf))!=-1) {
				fos.write(buf,0,size);
			}
			
			fos.close();
			bis.close();
			
			conn.disconnect();
			log.info("下载媒体文件成功,filePath="+filePath);
		} catch (Exception e) {
			filePath=null;
			log.error("下载媒体文件失败:{}",e);
		}
		return filePath;
	}
	
	
	public static void main(String[] args) {
		// 获取接口访问凭证
		String accessToken=getAccessToken("wx13c0a227486f7e64", "864e16284d38c05c62cddc1be000351e").getAccesstoken();
		// 上传多媒体文件
		WeixinMedia weixinMedia=uploadMedia(accessToken, "image", "http://localhost:8080/wechatapi/upload/sedion.jpg");
		System.err.println(weixinMedia.getMediaId());
		System.err.println(weixinMedia.getType());
		System.err.println(weixinMedia.getCreatedAt());
		
		// 下载多媒体文件
		String filePath=getMedia(accessToken, "", "D:/db");
		System.err.println(filePath);
	}
}
