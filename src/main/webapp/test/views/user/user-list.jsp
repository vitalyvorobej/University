<%@ page import="model.UserTableModel" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>User Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> User
                Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/user/list" class="nav-link">Users</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">List of Users</h3>
        <hr>
        <div class="container text-left">
            <%--<a href="<%=request.getContextPath()%>/user/new" class="btn btn-success">Add--%>
            <a href="/test/views/user/user-form.jsp" class="btn btn-success">Add
                New User</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>id</th>
                <th>login</th>
                <th>password</th>
                <th>role</th>
                <th>actions</th>
            </tr>
            </thead>
            <tbody>
            <!--   for (Todo todo: todos) {  -->
            <%
                List<UserTableModel> model = (ArrayList<UserTableModel>) request.getAttribute("listUser");

                for (UserTableModel user : model) {
                    out.print("<tr>");
                    out.print("<td>");
                    out.print(user.getUserTableId());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(user.getLogin());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(user.getPassword());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(user.getRole());
                    out.print("</td>");
                    out.print("</tr>");
                }
            %>
            <%--
            <c:forEach var="listUser" items="${listUser}">

                <tr>
                    <td>
                        <c:out value="${listUser.user_table_id}"/>
                    </td>
                    <td>
                        <c:out value="${listUser.login}"/>
                    </td>
                    <td>
                        <c:out value="${listUser.password}"/>
                    </td>
                    <td>
                        <c:out value="${listUser.role}"/>
                    </td>
                    <td>
                        <a href="/user/edit?user_table_id=<c:out value='${listUser.user_table_id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a
                                href="/user/delete?user_table_id=<c:out value='${listUser.user_table_id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>--%>
            <!-- } -->
            </tbody>

        </table>
    </div>
</div>
</body>

</html>