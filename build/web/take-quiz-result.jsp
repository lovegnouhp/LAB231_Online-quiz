<%--
    Document   : take-quiz-result
    Created on : Jul 18, 2021, 11:05:43 PM
    Author     : phuon
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <title>Take Quiz</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="nav-bar.jsp"/>

            <div class="main take-quiz">
                <div class="result">Your score
                    <c:choose>
                        <c:when test="${requestScope.percent >= 0.5}">
                            <span class="score passed">
                                <fmt:formatNumber type="number" pattern="0.00"
                                                  value="${requestScope.score}" maxFractionDigits="2" minFractionDigits="0"/>
                                (<fmt:formatNumber type="percent" value="${requestScope.percent}" maxFractionDigits="2"/>)
                                - Passed
                            </span>
                        </c:when>
                        <c:otherwise>
                            <span class="score not-passed"
                                  ><fmt:formatNumber type="number" pattern="0.00"
                                              value="${requestScope.score}" maxFractionDigits="2" minFractionDigits="0"/>
                                (<fmt:formatNumber type="percent" value="${requestScope.percent}" maxFractionDigits="2"/>)
                                - Not passed
                            </span>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="another-test">Take another test <a href="take-quiz"><button class="button">Start</button></a></div>
            </div>
        </div>
    </body>
</html>
