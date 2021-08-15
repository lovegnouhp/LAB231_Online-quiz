<%--
    Document   : register
    Created on : Jul 18, 2021, 11:04:33 PM
    Author     : phuon
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <title>Register</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="nav-bar.jsp"/>

            <div class="main register">
                <form action="register" method="POST">
                    <table>
                        <thead>
                            <tr>
                                <th>Registration Form</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>User Name:</td>
                                <td><input class="text-box" type="text" name="username" required /></td>
                            </tr>
                            <tr>
                                <td>Password:</td>
                                <td><input class="text-box" type="password" name="password" required /></td>
                            </tr>
                            <tr>
                                <td>User Type:</td>
                                <td>
                                    <select name="user-type">
                                        <option value="1">Teacher</option>
                                        <option value="0">Normal User</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Email:</td>
                                <td><input class="text-box" type="email" name="email" required /></td>
                            </tr>
                            <tr <c:if test="${requestScope.registerSuccess eq null
                                              or requestScope.registerSuccess eq true}">
                                      hidden
                                  </c:if>>
                                <td></td>
                                <td class="error">Username are already existed.</td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input class="button" type="submit" value="Register" /></td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
