<%--
    Document   : take-quiz
    Created on : Jul 18, 2021, 11:03:31 PM
    Author     : phuon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <script src="js/javascript.js" type="text/javascript"></script>
        <title>Take Quiz</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="nav-bar.jsp"/>

            <div class="main take-quiz">
                <div class="welcome">Welcome <span class="user-data">${sessionScope.account.username}</span></div>
                <form action="take-quiz" method="POST" onsubmit="return checkNumOfQuest()">
                    <table>
                        <tr>
                            <td>Enter number of questions:</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><input class="text-box" type="text" name="num-of-quest" required /></td>
                            <td></td>
                        </tr>

                        <tr>
                            <td></td>
                            <td><input class="button" type="submit" value="Start" /></td>
                        </tr>
                    </table>
                    <input type="hidden" id="total-quest" value="${totalQuest}"/>
                </form>
            </div>
        </div>
    </body>
</html>
