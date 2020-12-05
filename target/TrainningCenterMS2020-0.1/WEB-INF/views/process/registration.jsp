<%-- 
    Document   : registration
    Created on : Nov 6, 2020, 12:59:34 PM
    Author     : SMARTCS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    </head>
    <body>
        <div class="container">
            <div class="jumbotron">
                <h1 style="text-align:center; margin-bottom:60px;">Registration Form</h1>
                <label style="color:red;">${param['msg']}</label>
                <table class="table-bordered" width="100%">
                    <form:form method="POST" modelAttribute="registration">
                        <tbody>
                            <tr>
                                <td>
                                    <label class="col-sm-2 col-form-label col-form-label-sm" for="nameInput">Name: </label>
                                </td>
                                <td><form:input id="nameInput" path="name" palceholder="Enter Your Name" class="col-sm-10 form-control"/>
                                </td>
                                <td><form:errors path="name" style="color:red;" /></td>
                            </tr>
                            <tr>
                                <td>
                                    <label class="col-sm-2 col-form-label col-form-label-sm" for="nameInput">Phone: </label>
                                </td>
                                <td><form:input id="phoneInput" path="phone" palceholder="Enter Your Phone" class="col-sm-10 form-control"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label class="col-sm-2 col-form-label col-form-label-sm" for="nameInput">Email: </label>
                                </td>
                                <td><form:input id="emailInput" path="email" palceholder="Enter Your Email" class="col-sm-10 form-control"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label class="col-sm-2 col-form-label col-form-label-sm" for="courseInput">Course: </label>
                                </td>
                                <td>
                                    <form:select path="course" multiple="false" class="col-sm-10 form-control" onchange="onChangeCourse()">
                                        <form:options items="${courses}"  itemLabel="name" itemValue="id"/>
                                    </form:select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label class="col-sm-2 col-form-label col-form-label-sm" for="priceInput">Price: </label>
                                </td>
                                <td><form:input id="priceInput" path="price" class="col-sm-10 form-control"/></td>
                            </tr>
                            <tr>
                                <td>
                                    <label class="col-sm-2 col-form-label col-form-label-sm" for="paidInput">Paid: </label>
                                </td>
                                <td><form:input id="paidInput" path="paid" class="col-sm-10 form-control"/></td>
                            </tr>
                            <tr>
                                <td colspan="2">
                    <input type="submit" style="width:15%; float:left;" class="btn btn-success btn-lg "/>
                                </td>
                            </tr>
                        </tbody>
                    </form:form>
                </table>

            </div>
        </div>
        <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
        <script>
            function onChangeCourse() {
                var courseIdMenu = $("#course").val();
                $.ajax({
                    url: '${pageContext.request.contextPath}/process/registration/getCourse',
                    type: 'GET',
                    data: {
                        courseId: courseIdMenu
                    },
                    complete: function (data) {
                        var course = $.parseJSON(data.responseText);
                        var price = course['price'];
                        $("#priceInput").val(price);
                    }

                })
            }
        </script>
    </body>
</html>
