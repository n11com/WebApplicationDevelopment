<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" class=" js no-touch csstransitions">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>iDea | Blog</title>
    <link href="<c:url value="/resources/css/webfonts.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/font-awesome.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/fontello.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/magnific-popup.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/animations.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/owl.carousel.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body class="wide">
<div class="scrollToTop" style="display: none;"><i class="icon-up-open-big"></i></div>
<div class="page-wrapper">
<header class="header fixed clearfix">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <!-- header-left start -->
                <!-- ================ -->
                <div class="header-left clearfix">
                    <!-- logo -->
                    <div class="logo">
                        <a href="<c:url value="/" />"><img id="logo" src="resources/img/logo_red.png" alt="iDea"></a>
                    </div>
                    <!-- name-and-slogan -->
                    <div class="site-slogan">
                        Clean &amp; Powerful Bootstrap Theme
                    </div>
                </div>
                <!-- header-left end -->
            </div>
            <div class="col-md-9">
                <!-- header-right start -->
                <!-- ================ -->
                <div class="header-right clearfix">
                    <!-- main-navigation start -->
                    <!-- ================ -->
                    <div class="main-navigation animated">
                        <!-- navbar start -->
                        <!-- ================ -->
                        <nav class="navbar navbar-default" role="navigation">
                            <div class="container-fluid">
                                <!-- Toggle get grouped for better mobile display -->
                                <div class="navbar-header">
                                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-1">
                                        <span class="sr-only">Toggle navigation</span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                    </button>
                                </div>
                                <!-- Collect the nav links, forms, and other content for toggling -->
                                <div class="collapse navbar-collapse" id="navbar-collapse-1">
                                    <ul class="nav navbar-nav navbar-right">
                                        <c:if test="${sessionScope.user != null}">
                                            <li>
                                                <span>Welcome ${sessionScope.user.firstName} ${sessionScope.user.lastName}</span>
                                            </li>
                                            <li>
                                                <a href="<c:url value="/secure/addBlogPost" />">Add Blog Post</a>
                                            </li>
                                            <li>
                                                <a href="<c:url value="/cikis" />">Logout</a>
                                            </li>
                                        </c:if>
                                        <c:if test="${sessionScope.user == null}">
                                            <li>
                                                <a href="<c:url value="/uyeol" />">Sign Up</a>
                                            </li>
                                            <li class="active">
                                                <a href="<c:url value="/girisyap" />">Sign In</a>
                                            </li>
                                        </c:if>
                                    </ul>
                                </div>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- header end -->
<!-- main-container start -->
<!-- ================ -->
<section class="main-container" style="margin-top: 0px;">
    <div class="container">
        <div class="row">
            <!-- main start -->
            <!-- ================ -->
            <div class="main col-md-8">
                <!-- Forms start -->
                <!-- ============================================================================== -->
                <h2>Add Blog Entry</h2>
                <form role="form" action="<c:url value="addBlogPost" />" method="post">
                    <div class="form-group">
                        <label for="blogTitle">Blog Title</label>
                        <input type="text" class="form-control" id="blogTitle" name="title" placeholder="Blog Title">
                    </div>
                    <div class="form-group">
                        <label for="entry">Entry</label>
                        <textarea class="form-control" rows="3" id="entry" name="entry" placeholder="Blog Entry"></textarea>
                    </div>
                    <!-- div class="form-group">
                        <label for="exampleInputFile">File input</label>
                        <input type="file" id="exampleInputFile">
                        <p class="help-block">Example block-level help text here.</p>
                    </div -->
                    <button type="submit" class="btn btn-default">Add Entry</button>
                </form>

            </div>
            <!-- main end -->
        </div>
    </div>
</section>
<!-- main-container end -->
</div>
<!-- page-wrapper end -->
<!-- JavaScript files placed at the end of the document so the pages load faster
   ================================================== -->
<!-- Jquery and Bootstap core js files -->
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<!-- Modernizr javascript -->
<script type="text/javascript" src="resources/js/modernizr.js"></script>
<!-- Isotope javascript -->
<script type="text/javascript" src="resources/js/isotope.pkgd.min.js"></script>
<!-- Owl carousel javascript -->
<script type="text/javascript" src="resources/js/owl.carousel.js"></script>
<!-- Magnific Popup javascript -->
<script type="text/javascript" src="resources/js/jquery.magnific-popup.min.js"></script>
<!-- Appear javascript -->
<script type="text/javascript" src="resources/js/jquery.appear.js"></script>
<!-- Count To javascript -->
<script type="text/javascript" src="resources/js/jquery.countTo.js"></script>
<!-- Parallax javascript -->
<script src="resources/js/jquery.parallax-1.1.3.js"></script>
<!-- Contact form -->
<script src="resources/js/jquery.validate.js"></script>
<!-- SmoothScroll javascript -->
<script type="text/javascript" src="resources/js/jquery.browser.js"></script>
<script type="text/javascript" src="resources/js/SmoothScroll.js"></script>
<!-- Initialization of Plugins -->
<script type="text/javascript" src="resources/js/template.js"></script>
<!-- Custom Scripts -->
<script type="text/javascript" src="resources/js/custom.js"></script>

</body>
</html>