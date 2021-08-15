
<%--
    Document   : nav-bar
    Created on : Jul 18, 2021, 10:59:20 PM
    Author     : phuon
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:h="http://xmlns.jcp.org/jsf/html" xmlns:f="http://xmlns.jcp.org/jsf/core">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <title>Nav-bar</title>
    </head>
    <body>
        <div class="menu-bar">
            <a href="home">Home</a>
            <c:if test="${sessionScope.account ne null}">
                <a href="take-quiz">Take Quiz</a>
                <c:if test="${sessionScope.account.isTeacher eq true}">
                    <a href="make-quiz">Make Quiz</a>
                    <a href="manage-quiz">Manage Quiz</a>
                </c:if>
                <a href="logout" >Logout</a>
            </c:if>
        </div>
    </body>
</html>
