<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">

    <title>Yusuf Soysal</title>

    <link type="text/css" href="resources/main.css" rel="stylesheet">

</head>

<body>
<div id="container">
    <div class="content-wrapper">
        <div id="main-nav">
            <ul id="top-menu">
                <li><a href='<c:url value="/" />'>Home</a></li>
                <li><a href='<c:url value="/social" />'>Social</a></li>
                <li><a href='<c:url value="/forms" />'>Forms</a></li>
            </ul>
        </div>

        <div id="main-content">
            <div id="content">
                <div id="social" class="page">
                    <ul class="social_links">
                        <li>
                            <a href="${social.twitter != null ? social.twitter : "#"}" class="social">
                                <span class="ico twitter"></span>
                                <span class="name">Twitter</span>
                                <span class="address">${social.twitter}</span>
                            </a>

                            <a  href="${social.facebook != null ? social.facebook : "#"}" class="social">
                                <span class="ico facebook"></span>
                                <span class="name">Facebook</span>
                                <span class="address">${social.facebook}</span>
                            </a>
                        </li>
                        <li>
                            <a  href="${social.flickr != null ? social.flickr : "#"}" class="social">
                                <span class="ico flickr"></span>
                                <span class="name">Flickr</span>
                                <span class="address">${social.flickr}</span>
                            </a>

                            <a  href="${social.linkedin != null ? social.linkedin : "#"}" class="social">
                                <span class="ico linkedin"></span>
                                <span class="name">Linked In</span>
                                <span class="address">${social.linkedin}</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>