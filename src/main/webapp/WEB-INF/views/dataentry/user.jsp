<%-- 
    Document   : user
    Created on : Oct 31, 2020, 7:35:24 PM
    Author     : SMARTCS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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

        <title>User</title>
    </head>
    <body>
        <div class="container" >
            <div class="jumbotron">
                <c:if test="${edit}">
                    <h1 style="text-align:center; margin-bottom:60px;">Edit User</h1>
                </c:if>
                <c:if test="${not edit}">
                    <h1 style="text-align:center; margin-bottom:60px;">Add New User</h1>
                </c:if>
                <form:form method="POST" modelAttribute="user">
                    <c:if test="${edit}">
                        <form:hidden path="id" />
                    </c:if>
                    <label class="col-sm-2 col-form-label col-form-label-sm" for="name" style="padding: 5px 10px;">Name: </label>
                    <form:input type="text" path="name" placeholder="Enter Your Name" class="col-sm-10 form-control"/>
                    <br>
                    <form:errors style="color:red" path="name"/>
                    <br>

                    <label for="username" class="col-sm-2 col-form-label col-form-label-sm" style="padding: 5px 10px;">Username: </label>
                    <form:input type="text" path="username" placeholder="Enter Your Username" class="col-sm-10 form-control"/>
                    <br>
                    <form:errors style="color:red" path="username"/>
                    <br>

                    <label for="password" class="col-sm-2 col-form-label col-form-label-sm" style="padding: 5px 10px;">Password: </label>
                    <form:input type="text" path="password" placeholder="Enter Your Password" class="col-sm-10 form-control"/>
                    <br>
                    <form:errors style="color:red" path="password"/>
                    <br>

                    <label for="email" class="col-sm-2 col-form-label col-form-label-sm" style="padding: 5px 10px;">Email: </label>
                    <form:input type="text" path="email" placeholder="Enter Your Email" class="col-sm-10 form-control"/>
                    <br>
                    <form:errors style="color:red" path="email"/>
                    <br>

                    <label for="phone" class="col-sm-2 col-form-label col-form-label-sm" style="padding: 5px 10px;">Phone: </label>
                    <form:input type="text" path="phone" placeholder="Enter Your Phone" class="col-sm-10 form-control"/>
                    <br>
                    <form:errors style="color:red" path="phone"/>
                    <br>
                      <div class="form-group">
                    <label for="userRoles exampleFormControlSelect1" class="col-sm-2 col-form-label col-form-label-sm" style="padding: 5px 10px;">Roles: </label>
                    <form:select path="userRoles" class="form-control" id="exampleFormControlSelect1">
                        <form:options  items="${roles}" itemLabel="name" itemValue="id" />
                    </form:select>
                      </div>
                    <br>
                    <form:errors style="color:red" path="userRoles"/>
                    <br>
                    <input type="Submit" class="btn btn-success" style="margin-top: -57px; font-weight: bold;"/>
                </form:form>
            </div>
        </div>
    </body>
</html>
