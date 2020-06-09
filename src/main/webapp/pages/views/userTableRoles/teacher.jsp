<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teachers Work page</title>
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
    <h1>Teachers work page</h1>
</div>

<div class="topnav">
    <a href="<%=request.getContextPath()%>/pages/views/teacher/teacher.jsp">Fill form to finish registration</a>
    <a href="<%=request.getContextPath()%>/courseServlet">Show available course</a>
    <a href="<%=request.getContextPath()%>/pages/views/coursestudent/courseStudentMarkForm.jsp">Rate student</a>
    <a href="<%=request.getContextPath()%>/StudentListServlet">Show all Students</a>
    <a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a>

    <%--<a>Your personal ID - <%out.print(request.getAttribute("teacherid"));%></a>--%>

</div>


</body>
</html>
