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
    <title>Admin Page</title>
</head>
<% //In case, if Admin session is not set, redirect to Login page
    if ((request.getSession(false).getAttribute("Admin") == null)) {
%>
<jsp:forward page="/java/views/index.jsp"></jsp:forward>
<%} %>
<body>
<center><h2>Admin's Home</h2></center>

Welcome <%=request.getAttribute("login") %> select what you want:
<a href="/java/views/course/course.jsp">Add new course</a>


<div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>
</body>--%>
<head>
    <title>Admins Work page</title>
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
<body>

<div class="header">
    <h1>Admins work page</h1>
</div>

<div class="topnav">
    <a href="<%=request.getContextPath()%>/pages/views/course/course.jsp">Add new course</a>
    <a href="<%=request.getContextPath()%>/courseServlet">Show available course</a>
    <a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a>
</div>

</body>
</html>