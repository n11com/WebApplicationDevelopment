<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">

    <title>Yusuf Soysal</title>

    <link type="text/css" href="<c:url value="/resources/main.css"  />" rel="stylesheet">

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
                <div id="contact" class="page">
                    <form action="<c:url value="/forms/addResume" />" method="post">
                        <ul class="form-hold">
                            <li>
                                <label>Experiences <small>(Required)</small></label>
                                <textarea name="experiences" id="experiences">${resume.experiences}</textarea>
                            </li>

                            <li>
                                <label>Skill #1 <small>(Between 1-100, Required)</small></label>
                                <input type="text" id="skill1" name="skill1" value="${resume.skill1}">
                            </li>

                            <li>
                                <label>Skill #2 <small>(Between 1-100, Required)</small></label>
                                <input type="text" id="skill2" name="skill2" value="${resume.skill2}">
                            </li>

                            <li>
                                <label>Skill #3 <small>(Between 1-100, Required)</small></label>
                                <input type="text" id="skill3" name="skill3" value="${resume.skill3}">
                            </li>

                            <li>
                                <label>Skill #4 <small>(Between 1-100, Required)</small></label>
                                <input type="text" id="skill4" name="skill4" value="${resume.skill4}">
                            </li>

                            <li>
                                <label>Skill #5 <small>(Between 1-100, Required)</small></label>
                                <input type="text" id="skill5" name="skill5" value="${resume.skill5}">
                            </li>

                            <li>
                                <label>Skill #6 <small>(Between 1-100, Required)</small></label>
                                <input type="text" id="skill6" name="skill6" value="${resume.skill6}">
                            </li>

                            <li>
                                <c:if test="${param.resumeError}">
                                    <div class="error">
                                        You have errors in forms
                                    </div>
                                </c:if>
                                <input type="submit" class="submit-button" value="Send">
                            </li>

                        </ul>
                    </form>

                    <form action="<c:url value="/forms/addSocial" />" method="post">
                        <ul class="form-hold">
                            <li>
                                <label>Twitter <small>(Required)</small></label>
                                <input type="text" id="twitter" name="twitter" value="${social.twitter}">
                            </li>

                            <li>
                                <label>Facebook <small>(Required)</small></label>
                                <input type="text" id="facebook" name="facebook" value="${social.facebook}">
                            </li>

                            <li>
                                <label>Flickr <small>(Required)</small></label>
                                <input type="text" id="flickr" name="flickr" value="${social.flickr}">
                            </li>

                            <li>
                                <label>Linkedin <small>(Required)</small></label>
                                <input type="text" id="linkedin" name="linkedin" value="${social.linkedin}">
                            </li>

                            <li>
                                <c:if test="${param.socialError}">
                                    <div class="error">
                                        You have errors in forms
                                    </div>
                                </c:if>
                                <input type="submit" class="submit-button" value="Send">
                            </li>

                        </ul>
                    </form>

                    <br /><br /><br />
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>