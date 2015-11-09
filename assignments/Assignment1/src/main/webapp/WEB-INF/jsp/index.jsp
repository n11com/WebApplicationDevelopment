<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; cha set=UTF-8">
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
                <div id="index" class="page" style="display:block;">
                    <div class="inner-page">
                        <h1 class="name">Yusuf Soysal</h1>
                        <h2 class="sub-name">Backend Developer</h2>
                        <img src="https://pbs.twimg.com/profile_images/1245011351/profile_400x400.jpg" class="avatar" title="Meks Twitter Page">
                    </div>

                    <c:if test="${resume.experiences != null}">
                        <ul class="box">
                            <li>
                                <span title="70" style="width: ${resume.skill1}%;"></span>
                                <p>Skill #1 <strong>${resume.skill1}%</strong></p>
                            </li>

                            <li>
                                <span title="60" style="width: ${resume.skill2}%;"></span>
                                <p>Skill #2 <strong>${resume.skill2}%</strong></p>
                            </li>

                            <li>
                                <span title="100" style="width: ${resume.skill3}%;"></span>
                                <p>Skill #3 <strong>${resume.skill3}%</strong></p>
                            </li>

                            <li>
                                <span title="90" style="width: ${resume.skill4}%;"></span>
                                <p>Skill #4 <strong>${resume.skill4}%</strong></p>
                            </li>

                            <li>
                                <span title="35" style="width: ${resume.skill5}%;"></span>
                                <p>Skill #5 <strong>${resume.skill5}%</strong></p>
                            </li>

                            <li>
                                <span title="29" style="width: ${resume.skill6}%;"></span>
                                <p>Skill #6 <strong>${resume.skill6}%</strong></p>
                            </li>
                        </ul>

                        <h4>Experiences</h4>

                        <p>${resume.experiences}</p>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>