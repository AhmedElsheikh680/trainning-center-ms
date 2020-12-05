<%-- 
    Document   : role
    Created on : Oct 31, 2020, 2:13:52 PM
    Author     : SMARTCS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <div class="container" style="text-align:center">
            <div class="jumbotron">

                <c:if test="${edit}">
                    <h1 style="text-align:center; margin-bottom:60px;">Edit Role</h1>
                </c:if>
                <c:if test="${not edit}">
                    <h1 style="text-align:center; margin-bottom:60px;">Add New Role</h1>
                </c:if>
                <form:form method="POST" modelAttribute="role" >
                    <c:if test="${edit}">
                        <form:hidden path="id"/>
                    </c:if>
                    
                    <form:input class="col-sm-10 form-control" type="text" path="name" placeholder="Enter Your Name"/>
                    <br>
                    <form:errors path="name" style="color:red;" />

                    <br>
                    <input type="submit" style="width:15%; float:left;" class="btn btn-success btn-lg "/>
                </form:form>
            </div>
        </div>
    </body>
</html>
