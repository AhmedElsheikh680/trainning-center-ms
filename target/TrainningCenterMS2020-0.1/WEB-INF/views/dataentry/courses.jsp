<%-- 
    Document   : courses
    Created on : Oct 31, 2020, 9:23:30 PM
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

        <title>All Courses</title>
    </head>
    <body>
        <div class="container" style="text-align:center">
            <div class="jumbotron">
                <h1>Courses</h1>
                <br/>
                <label style="color:red; font-size:20px">${param['added']}</label>
                <label style="color:red; font-size:20px">${param['updated']}</label>
                <label style="color:red; font-size:20px">${param['deleted']}</label>
                <br>
                <a href="${pageContext.request.contextPath}/dataentry/course/new" class="btn btn-success" style="padding: 10px; font-weight:bold;">Add New Course</a><br/><br>
                <table  style="margin: auto"  class="table table-bordered" border="1">
                    <tr style="background-color: #a1e1b0; color:#fff; font-weight:bold;">
                        <th style="text-align:center;" scope="col">ID </th>
                        <th style="text-align:center;" scope="col">Name </th>
                        <th style="text-align:center;" scope="col">lab  </th>
                        <th style="text-align:center;" scope="col">Hours </th>
                        <th style="text-align:center;" scope="col">price </th>
                        <th style="text-align:center;" scope="col" colspan="2">Action</th>
                    </tr>
                    <c:forEach items="${courses}" var="course">
                        <tr style="color: #2d1d1d;">
                            <td scope="row">${course.id}</td>
                            <td>${course.name}</td>
                            <td>${course.lab.name}</td>
                            <td>${course.hours}</td>
                            <td>${course.price}</td>
                            <td><a href="${pageContext.request.contextPath}/dataentry/course/edit/${course.id}" style="padding: 10px 30px; font-weight: bold;" class="btn btn-primary">Edit</a></td>
                            <td><a href="${pageContext.request.contextPath}/dataentry/course/delete/${course.id}" class="btn btn-danger" style="padding: 10px 20px; font-weight: bold;">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
