<%@ page import="model.CourseModel" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
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
            <a style="color: #f1f1f1">List of Course </a>
        </div>

        <ul class="navbar-nav">
            <%--<li><a href="<%=request.getContextPath()%>/user/list" class="nav-link">Users</a></li>--%> <%--TODO ДОПИСАТЬ возвращение на страницу курсов--%>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">Available Courses</h3>
        <hr>
        <div class="container text-left">
            <%--<a href="<%=request.getContextPath()%>/user/new" class="btn btn-success">Add--%>
            <%--<a href="/test/views/user/user-form.jsp" class="btn btn-success">Add
                New User</a>--%> <%--TODO дописать создание курса для пользователя админ--%>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Course_name</th>
                <th>Teacher_id</th>
                <th>Date start</th>
                <th>Date end</th>
            </tr>
            </thead>
            <tbody>
            <!--   for (Todo Попробовать добавить поле имени преподавателя  ) {  -->
            <%
                List<CourseModel> model = (ArrayList<CourseModel>) request.getAttribute("listCourse");

                for (CourseModel course : model) {
                    out.print("<tr>");
                    out.print("<td>");
                    out.print(course.getCourseId());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(course.getCourseName());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(course.getTeacher().getTeacherId());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(course.getCourseStartDate());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(course.getCourseEndDate());
                    out.print("</td>");
                    out.print("</tr>");
                }
            %>

            </tbody>

        </table>
    </div>
</div>
</body>
</html>
