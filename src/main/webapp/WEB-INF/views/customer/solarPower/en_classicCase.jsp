<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<html>
<head>
  <!-- Document Title -->
    <title>Photosynthetic silicon energy battery only [official website]|photosynthetic silicon energy battery company official website|photosynthetic silicon energy battery manufacturer</title>
    <meta name="keywords" content="Photosynthetic silicon energy storage battery, silicon energy storage battery, silicon energy battery, photosynthetic silicon energy battery official website, photosynthetic silicon energy battery, photosynthetic silicon energy battery official website, photosynthetic silicon energy,
    , solar energy storage battery, photosynthetic silicon energy battery official website, battery manufacturer, power generation system, Hunan frontier, cutting-edge technology" />
    <meta name="description" content="Photosynthetic silicon can always adhere to the quality, full capacity, non-virtual standard, not fake, the promised after-sales warranty service is adhered to, and currently has a certain brand value in the industry, please be sure to provide a formal purchase channel for trademark brand inquiry qualification. . Buy Photosynthetic Silicon Energy Battery Please look for the Tmall flagship store and Hunan Frontier Technology website www.150ah.com, with blue label and industrial and commercial certification as genuine. Look for photosynthetic silicon energy, have a business license certification, Baidu credit certification is genuine. Contact number: +86-731-86663578" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta name="author" content="M_Adnan" />
    <meta name="baidu-site-verification" content="UC04SFA0NB" />


    <!-- SLIDER REVOLUTION 4.x CSS SETTINGS -->
    <link rel="stylesheet" type="text/css" href="${staticPath }/static/customer/rs-plugin/css/settings.css" media="screen" />
    <link rel="shortcut icon" href="${staticPath }/static/images/favicon.png" type="image/x-icon" />
    <!-- StyleSheets -->
    <link rel="stylesheet" href="${staticPath }/static/customer/css/ionicons.min.css">
    <link rel="stylesheet" href="${staticPath }/static/customer/css/bootstrap.min.css">
    <link rel="stylesheet" href="${staticPath }/static/customer/css/font-awesome.min.css">
    <link rel="stylesheet" href="${staticPath }/static/customer/css/main.css">
    <link rel="stylesheet" href="${staticPath }/static/customer/css/style.css">
    <link rel="stylesheet" href="${staticPath }/static/customer/css/responsive.css">

   <!-- <%@ include file="/commons/basejs.jsp" %>
    <link rel="stylesheet" type="text/css" href="${staticPath }/static/style/css/main.css">
    <script type="text/javascript" src="${staticPath }/static/js/main.js"></script>-->
    <!-- 前台登录css-->
    <link rel="stylesheet" href="${staticPath }/static/customer/css/loginIndex.css">
    <!-- Fonts Online -->
    <link href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i" rel="stylesheet">
    <script type="text/javascript" src="${staticPath }/static/js/jquery-easyui/jquery.min.js"></script>
    <!-- 前台登录js-->
    <script  src="${staticPath }/static/js/index.js"></script>
  <style>
    #case{
      color: #105b63;
    }
  </style>
</head>
<body>
<jsp:include page="en_header.jsp"></jsp:include>

<div id="wrap" class="layout-1">
    <!-- Content -->
    <div id="content">

        <section class="padding-top-60 padding-bottom-60">
            <div class="container">

                <!-- heading -->
                <div class="heading">
                    <h2>Classic Case</h2>
                    <hr>
                </div>
                <div id="blog-slide" class="with-nav">
                    <c:forEach var="demo" items="${caseImage}">
                        <div class="blog-post">

                            <article> <img class="img-responsive" src="${staticPath}/static${demo.imagePath}${demo.fileName}" alt="" ><span><i class="fa fa-bookmark-o"></i> ${demo.updateTime}</span>
                                <p>${demo.en_imageDescription} </p>
                            </article>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>
    </div>




<link rel="stylesheet" type="text/css" href="${staticPath }/static/customer/css/main.css">
<link rel="stylesheet" type="text/css" href="${staticPath }/static/customer/css/talkStyle.css?v=10">

<script src="${staticPath }/static/customer/js/vendors/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="${staticPath }/static/customer/js/main.js"></script>
<!-- JavaScripts -->
<script src="${staticPath }/static/customer/js/vendors/wow.min.js"></script>
<script src="${staticPath }/static/customer/js/vendors/bootstrap.min.js"></script>
<script src="${staticPath }/static/customer/js/vendors/own-menu.js"></script>
<script src="${staticPath }/static/customer/js/vendors/jquery.sticky.js"></script>
<script src="${staticPath }/static/customer/js/vendors/owl.carousel.min.js"></script>
<!-- SLIDER REVOLUTION 4.x SCRIPTS  -->
<script type="text/javascript" src="${staticPath }/static/customer/rs-plugin/js/jquery.tp.t.min.js"></script>
<script type="text/javascript" src="${staticPath }/static/customer/rs-plugin/js/jquery.tp.min.js"></script>
    <a href="#" class="cd-top"><i class="fa fa-angle-up"></i></a>
</div>
</body>
<jsp:include page="talk.jsp"></jsp:include>
<jsp:include page="en_footer.jsp"></jsp:include>
</html>
