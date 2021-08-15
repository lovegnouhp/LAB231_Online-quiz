<%--
    Document   : make-quiz
    Created on : Jul 18, 2021, 11:03:50 PM
    Author     : phuon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <script src="js/javascript.js" type="text/javascript"></script>
        <title>Make Quiz</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="nav-bar.jsp"/>

            <div class="main make-quiz">
                <form action="make-quiz" method="POST" onsubmit="return checkAnswers()">
                    <table>
                        <tr>
                            <td>Question:</td>
                            <td><textarea name="question" rows="7" cols="50" required></textarea></td>
                        </tr>
                        <tr>
                            <td>Option1:</td>
                            <td><textarea name="option1" rows="3" cols="50" required></textarea></td>
                        </tr>
                        <tr>
                            <td>Option2:</td>
                            <td><textarea name="option2" rows="3" cols="50" required></textarea></td>
                        </tr>
                        <tr>
                            <td>Option3:</td>
                            <td><textarea name="option3" rows="3" cols="50" required></textarea></td>
                        </tr>
                        <tr>
                            <td>Option4:</td>
                            <td><textarea name="option4" rows="3" cols="50" required></textarea></td>
                        </tr>
                        <tr>
                            <td>Answer(s):</td>
                            <td onchange="checkAnswers()">
                                <input id="op1" type="checkbox" name="answer" value="1" /> <label for="op1">Option 1</label>
                                <input id="op2" type="checkbox" name="answer" value="2" /> <label for="op2">Option 2</label>
                                <input id="op3" type="checkbox" name="answer" value="3" /> <label for="op2">Option 3</label>
                                <input id="op4" type="checkbox" name="answer" value="4" /> <label for="op2">Option 4</label>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input class="button" type="submit" value="Save" /></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
