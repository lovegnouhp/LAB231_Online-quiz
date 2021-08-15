
<%--
    Document   : home
    Created on : Jul 18, 2021, 10:58:38 PM
    Author     : phuon
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <title>Home Page</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="nav-bar.jsp"/>

            <div class="main login">
                <c:choose>
                    <c:when test="${sessionScope.account ne null}">
                        <div class="welcome">
                            Welcome <span class="user-data">${sessionScope.account.username}</span><br/>
                            Your role: <span class="user-data"><c:choose>
                                    <c:when test="${sessionScope.account.isTeacher}">Teacher</c:when>
                                    <c:otherwise>Normal user</c:otherwise>
                                </c:choose>
                            </span><br/>
                            Your email: <span class="user-data">${sessionScope.account.email}</span>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <form action="home" method="POST">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Login Form</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>User Name:</td>
                                        <td><input class="text-box" type="text" name="username" required/></td>
                                    </tr>
                                    <tr>
                                        <td>Password:</td>
                                        <td><input class="text-box" type="password" name="password" required/></td>
                                    </tr>
                                    <tr <c:if test="${requestScope.loginSuccess eq null
                                                      or requestScope.loginSuccess eq true}">
                                              hidden
                                          </c:if>>
                                        <td></td>
                                        <td class="error">Incorrect username or password.</td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td>
                                            <input class="button" type="submit" value="Sign in" />
                                            <a href="register">Register</a>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </body>
</html>
