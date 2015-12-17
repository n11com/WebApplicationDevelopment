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
                <h1 class="page-title">${entry.title}</h1>
                <!-- page-title end -->

                <!-- blogpost start -->
                <article class="clearfix blogpost full">
                    <div class="blogpost-body">
                        <div class="side">
                            <div class="post-info">
                                <span class="day"><fmt:formatDate pattern="dd" value="${entry.createDate}" /></span>
                                <span class="month"><fmt:formatDate pattern="MMM yyyy" value="${entry.createDate}" /></span>
                            </div>
                        </div>
                        <div class="blogpost-content">
                            <header>
                                <div class="submitted"><i class="fa fa-user pr-5"></i> by ${entry.author.firstName} ${entry.author.lastName}</div>
                            </header>
                            <img src="<c:url value="${entry.imagePath}" />" alt="">
                            <p>${entry.entry}</p>
                        </div>
                    </div>
                    <footer class="clearfix">
                        <ul class="links pull-left">
                            <li><i class="fa fa-comment-o pr-5"></i> <a href="http://htmlcoder.me/preview/idea/v.1.3/html/blog-post.html#">22 comments</a> |</li>
                            <li><i class="fa fa-tags pr-5"></i>
                                <c:forEach items="${tags}" var="tag">
                                    <a href="<c:url value="/?tagId=${tag.id}" />">${tag.tagName}</a>
                                </c:forEach>
                            </li>
                        </ul>
                    </footer>
                </article>
                <!-- blogpost end -->

                <!-- comments start -->
                <div class="comments">
                    <h2 class="title">There are 3 comments</h2>

                    <!-- comment start -->
                    <div class="comment clearfix">
                        <div class="comment-avatar">
                            <img src="./iDea _ Blogpost_files/avatar.jpg" alt="avatar">
                        </div>
                        <div class="comment-content">
                            <h3>Comment title</h3>
                            <div class="comment-meta">By <a href="http://htmlcoder.me/preview/idea/v.1.3/html/blog-post.html#">admin</a> | Today, 12:31</div>
                            <div class="comment-body clearfix">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo </p>
                                <a href="./iDea _ Blogpost_files/iDea _ Blogpost.html" class="btn btn-gray more pull-right"><i class="fa fa-reply"></i> Reply</a>
                            </div>
                        </div>

                        <!-- comment start -->
                        <div class="comment clearfix">
                            <div class="comment-avatar">
                                <img src="./iDea _ Blogpost_files/avatar.jpg" alt="avatar">
                            </div>
                            <div class="comment-content clearfix">
                                <h3>Comment title</h3>
                                <div class="comment-meta">By <a href="http://htmlcoder.me/preview/idea/v.1.3/html/blog-post.html#">admin</a> | Today, 12:31</div>
                                <div class="comment-body">
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo </p>
                                    <a href="./iDea _ Blogpost_files/iDea _ Blogpost.html" class="btn btn-gray more pull-right"><i class="fa fa-reply"></i> Reply</a>
                                </div>
                            </div>
                        </div>
                        <!-- comment end -->

                    </div>
                    <!-- comment end -->

                    <!-- comment start -->
                    <div class="comment clearfix">
                        <div class="comment-avatar">
                            <img src="./iDea _ Blogpost_files/avatar.jpg" alt="avatar">
                        </div>
                        <div class="comment-content clearfix">
                            <h3>Comment title</h3>
                            <div class="comment-meta">By <a href="http://htmlcoder.me/preview/idea/v.1.3/html/blog-post.html#">admin</a> | Today, 12:31</div>
                            <div class="comment-body">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo </p>
                                <a href="./iDea _ Blogpost_files/iDea _ Blogpost.html" class="btn btn-gray more pull-right"><i class="fa fa-reply"></i> Reply</a>
                            </div>
                        </div>
                    </div>
                    <!-- comment end -->

                </div>
                <!-- comments end -->

                <!-- comments form start -->
                <div class="comments-form">
                    <h2 class="title">Add your comment</h2>
                    <form role="form" id="comment-form">
                        <div class="form-group has-feedback">
                            <label for="name4">Name</label>
                            <input type="text" class="form-control" id="name4" placeholder="" name="name4" required="">
                            <i class="fa fa-user form-control-feedback"></i>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="subject4">Subject</label>
                            <input type="text" class="form-control" id="subject4" placeholder="" name="subject4" required="">
                            <i class="fa fa-pencil form-control-feedback"></i>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="message4">Message</label>
                            <textarea class="form-control" rows="8" id="message4" placeholder="" name="message4" required=""></textarea>
                            <i class="fa fa-envelope-o form-control-feedback"></i>
                        </div>
                        <input type="submit" value="Submit" class="btn btn-default">
                    </form>
                </div>
                <!-- comments form end -->

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