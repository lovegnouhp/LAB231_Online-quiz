
<%--
    Document   : do-quiz
    Created on : Jul 18, 2021, 11:05:30 PM
    Author     : phuon
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <script src="js/javascript.js" type="text/javascript"></script>
        <title>Take Quiz</title>
    </head>
    <body onload="startTimer()">
        <div class="container">
            <jsp:include page="nav-bar.jsp"/>

            <div class="main take-quiz">
                <form id="question-form" action="take-quiz" method="POST">
                    <div class="question">
                        <div class="navigate-button">
                            Welcome <span class="user-data">${sessionScope.account.username}</span>
                        </div>
                        <div class="countdown">Time remaining <span id="timer"></span></div>
                        <div class="question-detail">
                            ${sessionScope.bank[sessionScope.currentIndex].question}<br />
                            <input type="checkbox" name="answer" value="1" /> ${sessionScope.bank[sessionScope.currentIndex].option1}<br />
                            <input type="checkbox" name="answer" value="2" /> ${sessionScope.bank[sessionScope.currentIndex].option2}<br />
                            <input type="checkbox" name="answer" value="3" /> ${sessionScope.bank[sessionScope.currentIndex].option3}<br />
                            <input type="checkbox" name="answer" value="4" /> ${sessionScope.bank[sessionScope.currentIndex].option4}<br />
                        </div>
                    </div>
                    <div class="navigate-button">
                        <input class="button" type="submit" value="<c:choose><c:when
                                       test="${fn:length(sessionScope.bank) eq (sessionScope.currentIndex+1)}"
                                       >Finish</c:when><c:otherwise>Next</c:otherwise></c:choose>">
                               </div>
                                   <input type="hidden" id="expired-time" value="${sessionScope.expiredTime}"/>
                </form>
            </div>
        </div>
    </body>
</html>
