<%--
  Created by IntelliJ IDEA.
  User: limee
  Date: 20.05.2020
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--<head>
    <title>Student home</title>
</head>
<% //In case, if Editor session is not set, redirect to Login page
    if ((request.getSession(false).getAttribute("Student") == null)) {
%>
<jsp:forward page="/pages/views/index.jsp"></jsp:forward>
<%} %>
<body>
<div style="text-align: center;"><h2>Student Home</h2></div>
Welcome <%=request.getAttribute("login") %>, to complete registration <a href="/java/views/student/student.jsp">fill in
    the personal blank</a>

<div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>

</body>--%>

<head>
    <title>Students Work page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
        }

        /* Style the header */
        .header {
            background-color: #f1f1f1;
            padding: 20px;
            text-align: center;
        }

        /* Style the top navigation bar */
        .topnav {
            overflow: hidden;
            background-color: #333;
        }

        /* Style the topnav links */
        .topnav a {
            float: left;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        /* Change color on hover */
        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }
    </style>
</head>
<% //In case, if Editor session is not set, redirect to Login page
    if ((request.getSession(false).getAttribute("Student") == null)) {
%>
<jsp:forward page="/pages/views/index.jsp"></jsp:forward>
<%} %>
<body>

<div class="header">
    <h1>Students work page</h1>
</div>

<div class="topnav">
    <%--<a href="<%=request.getContextPath()%>/pages/views/student/student.jsp">Fill form to finish registration</a>--%>
    <a href="<%=request.getContextPath()%>/courseServlet">Show available course</a>
    <a href="<%=request.getContextPath()%>/pages/views/coursestudent/courseentryform.jsp">Enroll in a course</a>
    <a>Your student_id - <%out.print(session.getAttribute("id"));%></a>
    <a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a>

</div>

</body>
</html>
