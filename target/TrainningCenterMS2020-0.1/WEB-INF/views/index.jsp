<%-- 
    Document   : index
    Created on : Oct 31, 2020, 10:51:03 AM
    Author     : SMARTCS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <title>Home</title>
    </head>
    <body>
        <div class="container" >

            <div class="jumbotron">
                <h1 style="text-align:center; margin-bottom:60px;">Hello World!</h1>
                <h2 style="text-align: center;">
                    <a href="<c:url value="/logout" />">Logout</a>
                </h2>
                <h2 style="text-align:center">
                    <a href="${pageContext.request.contextPath}/process/registration/new">New Registration</a>
                </h2>
                <h2 style="text-align: center;">
                    <a href="${pageContext.request.contextPath}/report/courseStudent">Registration Report</a>
                </h2>
            </div>
        </div>
    </body>
</html>
