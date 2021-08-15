<%--
    Document   : manage-quiz
    Created on : Jul 18, 2021, 11:04:02 PM
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
        <title>Manage Quiz</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="nav-bar.jsp"/>

            <div class="main manage-quiz">
                <c:choose>
                    <c:when test="${requestScope.numOfQuestion > 0}">
                        <div class="title">Number of questions: <span class="num-of-quest">${requestScope.numOfQuestion}</span></div>
                        <table>
                            <thead>
                                <tr>
                                    <th class="left">Question</th>
                                    <th class="right">DateCreated</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="q" items="${requestScope.questions}">
                                    <tr>
                                        <td class="left">${q.question}</td>
                                        <td class="right"><fmt:formatDate pattern="dd-MMM-yyyy" value="${q.dateCreated}"/></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:when>
                    <c:otherwise><div class="title">You haven't have any quiz yet.</div></c:otherwise>
                </c:choose>


            </div>
        </div>
    </body>
</html>
