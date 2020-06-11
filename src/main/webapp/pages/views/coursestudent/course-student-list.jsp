<%@ page import="model.CourseStudentModel" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
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
            <a style="color: #f1f1f1" href="<course:url value="/pages/views/userTableRoles/teacher.jsp"/>">Back to work page </a>
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
                <th>student id</th>
                <th>student name</th>
                <th>student second name</th>
                <th>course name</th>
                <th>course id</th>
                <%--<th>id table</th>--%>
            </tr>
            </thead>
            <tbody>
            <%
                List<CourseStudentModel> model = (ArrayList<CourseStudentModel>) request.getAttribute("listStudent");

                for (CourseStudentModel student : model) {
                    out.print("<tr>");
                    out.print("<td>");
                    out.print(student.getStudentModel().getStudentId());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(student.getStudentModel().getStudentName());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(student.getStudentModel().getStudentSecondName());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(student.getCourseModel().getCourseName());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(student.getCourseModel().getCourseId());
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
