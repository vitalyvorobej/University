<%@ page import="model.CourseModel" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="model.StudentModel" %><%--
  Created by IntelliJ IDEA.
  User: limee
  Date: 30.05.2020
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="course" %>
<html>
<head>
    <title>Course Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: black">
        <div>
            <a style="color: #f1f1f1" href="/pages/views/userTableRoles/teacher.jsp">Back to work page </a>
        </div>

        <ul class="navbar-nav">
            <%-- <a href="/java/views/userTableRoles/teacher.jsp">Back to work page</a>--%>
            <%--<li><a href="<%=request.getContextPath()%>/user/list" class="nav-link">Users</a></li>--%> <%--TODO ДОПИСАТЬ возвращение на страницу курсов--%>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">Students</h3>
        <hr>
        <div class="container text-left">
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Second name</th>
                <%--<th>id table</th>--%>
            </tr>
            </thead>
            <tbody>
            <%
                List<StudentModel> model = (ArrayList<StudentModel>) request.getAttribute("listStudent");

                for (StudentModel student : model) {
                    out.print("<tr>");
                    out.print("<td>");
                    out.print(student.getStudentId());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(student.getStudentName());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(student.getStudentSecondName());
                    out.print("</td>");
                    /*out.print("<td>");
                    out.print(student.getUserTableId());
                    out.print("</td>");*/
                    out.print("</tr>");
                }
            %>

            </tbody>

        </table>
    </div>
</div>
</body>
</html>
