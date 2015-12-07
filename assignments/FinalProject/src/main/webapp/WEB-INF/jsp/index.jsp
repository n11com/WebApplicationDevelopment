<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en" class=" js no-touch csstransitions">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>iDea | Blog</title>
    <link href="resources/css/webfonts.css" rel="stylesheet" type="text/css">
    <link href="resources/css/bootstrap.css" rel="stylesheet">
    <link href="resources/css/font-awesome.css" rel="stylesheet">
    <link href="resources/css/fontello.css" rel="stylesheet">
    <link href="resources/css/magnific-popup.css" rel="stylesheet">
    <link href="resources/css/animations.css" rel="stylesheet">
    <link href="resources/css/owl.carousel.css" rel="stylesheet">
    <link href="resources/css/style.css" rel="stylesheet">
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
                <!-- page-title start -->
                <!-- ================ -->
                <h1 class="page-title">Blog Masonry Layout</h1>
                <div class="separator-2"></div>
                <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptas nulla suscipit <br class="hidden-sm hidden-xs"> unde rerum mollitia dolorum.</p>
                <!-- page-title end -->
                <!-- masonry grid start -->
                <div class="masonry-grid row" style="position: relative; height: 2641.16px;">

                    <c:forEach items="${entries}" var="entry">
                        <!-- masonry grid item start -->
                        <div class="masonry-grid-item col-sm-6" style="position: absolute; left: 0px; top: 0px;">
                            <!-- blogpost start -->
                            <article class="clearfix blogpost">
                                <div class="overlay-container">
                                    <img src="./iDea _ Blog_files/blog-1.jpg" alt="">
                                    <div class="overlay">
                                        <div class="overlay-links">
                                            <a href="http://htmlcoder.me/preview/idea/v.1.3/html/blog-post.html"><i class="fa fa-link"></i></a>
                                            <a href="./iDea _ Blog_files/blog-1.jpg" class="popup-img-single hoverZoomLink" title="image title"><i class="fa fa-search-plus"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="blogpost-body">
                                    <div class="post-info">
                                        <span class="day"><fmt:formatDate pattern="dd" value="${entry.createDate}" /></span>
                                        <span class="month"><fmt:formatDate pattern="MMM yyyy" value="${entry.createDate}" /></span>
                                    </div>
                                    <div class="blogpost-content">
                                        <header>
                                            <h2 class="title"><a href="#">${entry.title}</a></h2>
                                            <div class="submitted"><i class="fa fa-user pr-5"></i> by <a href="#">${entry.author.firstName} ${entry.author.lastName}</a></div>
                                        </header>
                                        <p>${fn:substring(entry.entry, 0, 100)}</p>
                                    </div>
                                </div>
                                <footer class="clearfix">
                                    <ul class="links pull-left">
                                        <li><i class="fa fa-comment-o pr-5"></i> <a href="./iDea _ Blog_files/blog-masonry-sidebar.html">22 comments</a> |</li>
                                        <li><i class="fa fa-tags pr-5"></i> <a href="./iDea _ Blog_files/blog-masonry-sidebar.html">tag 1</a></li>
                                    </ul>
                                    <a class="pull-right link" href="http://htmlcoder.me/preview/idea/v.1.3/html/blog-post.html"><span>Read more</span></a>
                                </footer>
                            </article>
                            <!-- blogpost end -->
                        </div>
                        <!-- masonry grid item end -->
                    </c:forEach>
                </div>
                <!-- masonry grid end -->
            </div>
            <!-- main end -->
            <!-- sidebar start -->
            <aside class="col-md-3 col-md-offset-1">
                <div class="sidebar">
                    <div class="block clearfix">
                        <h3 class="title">Tags</h3>
                        <div class="separator"></div>
                        <div class="tags-cloud">
                            <div class="tag">
                                <a href="./iDea _ Blog_files/blog-masonry-sidebar.html">energy</a>
                            </div>
                            <div class="tag">
                                <a href="./iDea _ Blog_files/blog-masonry-sidebar.html">business</a>
                            </div>
                            <div class="tag">
                                <a href="./iDea _ Blog_files/blog-masonry-sidebar.html">food</a>
                            </div>
                            <div class="tag">
                                <a href="./iDea _ Blog_files/blog-masonry-sidebar.html">fashion</a>
                            </div>
                            <div class="tag">
                                <a href="./iDea _ Blog_files/blog-masonry-sidebar.html">finance</a>
                            </div>
                            <div class="tag">
                                <a href="./iDea _ Blog_files/blog-masonry-sidebar.html">culture</a>
                            </div>
                            <div class="tag">
                                <a href="./iDea _ Blog_files/blog-masonry-sidebar.html">health</a>
                            </div>
                            <div class="tag">
                                <a href="./iDea _ Blog_files/blog-masonry-sidebar.html">sports</a>
                            </div>
                            <div class="tag">
                                <a href="./iDea _ Blog_files/blog-masonry-sidebar.html">life style</a>
                            </div>
                            <div class="tag">
                                <a href="./iDea _ Blog_files/blog-masonry-sidebar.html">books</a>
                            </div>
                        </div>
                    </div>
                </div>
            </aside>
            <!-- sidebar end -->
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