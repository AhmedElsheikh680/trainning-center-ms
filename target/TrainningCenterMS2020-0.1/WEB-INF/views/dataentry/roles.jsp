<%-- 
    Document   : roles
    Created on : Oct 31, 2020, 4:19:36 PM
    Author     : SMARTCS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
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

        <title>Roles</title>
    </head>
    <body>
        <div class="container" style="text-align:center">
            <div class="jumbotron">
                <h1>Roles</h1>
                <label style="color:red; font-weight:bold; font-size:25px;">${param['message']}</label>
                <label style="color:red; font-weight:bold; font-size:25px;">${param['updated']}</label>
                <label style="color:red; font-weight:bold; font-size:25px;">${param['deleted']}</label>
                <br><br>
                <a href="${pageContext.request.contextPath}/dataentry/role/new" class="btn btn-success" style="padding: 10px; font-weight:bold;">Add New Role</a>
                </br></br>
                <table class=" table table-bordered" style="margin:auto">
                    <tr style="background-color: #a1e1b0; color:#fff; font-weight:bold;">
                        <th style="text-align:center;" scope="col">ID </th>
                        <th style="text-align:center;" scope="col">Name </th>
                        <th style="text-align:center;" scope="col" colspan="2">Action </th>
                    </tr>
                    <c:forEach items="${roles}" var="role">
                        <tr style="color: #2d1d1d;">
                            <td scope="row">${role.id}</td>
                            <td>${role.name}</td>
                            <td style="padding: 5px;"><a href="${pageContext.request.contextPath}/dataentry/role/edit/${role.id}" class="btn btn-primary" style="padding: 10px 30px;">Edit</a></td>
                            <td style="padding: 5px;"><a href="${pageContext.request.contextPath}/dataentry/role/delete/${role.id}" class="btn btn-danger" style="padding: 10px 20px;">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
