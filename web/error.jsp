<%--
    Document   : error
    Created on : Jul 18, 2021, 11:15:33 PM
    Author     : phuon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Error</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="nav-bar.jsp"/>

            <div class="main">
                <div class="error">
                    <h3>Error: ${requestScope.error}</h3>
                </div>
            </div>
        </div>
    </body>
</html>
