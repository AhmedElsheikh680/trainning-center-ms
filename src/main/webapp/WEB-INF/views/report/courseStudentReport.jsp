<%-- 
    Document   : CourseStudentReport
    Created on : Nov 7, 2020, 3:24:25 PM
    Author     : SMARTCS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Student Report</title>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <style>
            .myInput{
                width: 249px;
                padding-left: 16px;
                font-weight: bold;
                font-size: 15px;
            }
            label{
                font-size: 25px;
            }
        </style>
    </head>
    <body>
        <div class="container" >
            <div class="jumbotron">
                <h1 style="text-align: center;">Course Student Report</h1>
                <form:form method="POST" modelAttribute="courseStudentReportDto">
                    <table style="margin: auto; margin-top:60px;">
                        <tr>
                            <td><label>Date From: </label></td>
                            <td>
                                <input class="myInput" type="text" id="fromDateInput" name="fromDate"
                                       value='<fmt:formatDate value="${courseStudentReportDto.fromDate}"/>' required />
                            </td>
                        </tr>
                        <tr>
                            <td><label>Date To: </label></td>
                            <td>
                                <input class="myInput" type="text" id="toDateInput" name="toDate"
                                       value='<fmt:formatDate value="${courseStudentReportDto.toDate}"/>' required />
                            </td>
                        </tr>
                        <tr>
                            <td><label>Course: </label></td>
                            <td>
                                <select class="myInput" name="course">
                                    <c:forEach items="${courses}" var="course">

                                        <option value="${course.id}">${course.name} - ${course.price}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="submit" value="View Report"  class="btn btn-success btn-lg "/>
                            </td>
                        </tr>
                    </table>
                </form:form>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#fromDateInput").datepicker({dateFormat: 'mm/dd/yyyy'});
                $("#toDateInput").datepicker({dateFormat: 'mm/dd/yyyy'});
            });
        </script>

    </body>
</html>
