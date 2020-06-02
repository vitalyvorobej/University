<%--
  Created by IntelliJ IDEA.
  User: limee
  Date: 01.06.2020
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mark form for Teacher</title>
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
    <h1>Mark form for Teacher</h1>
</div>
<div class="topnav">
    <a href="/test/views/userTableRoles/teacher.jsp">Back to work page</a>
</div>
<div class="bottom">
    <form action="/courseStudentServlet" method="post"> <%--TODO change pass--%>
        <div style="text-align: center;">
            <label for="student_id">Enter student id:</label><br>
            <input type="text" minlength="1" maxlength="40" id="student_id" name="student_id"><br>
            <label for="mark">Enter mark:</label><br>
            <input type="text" minlength="1" maxlength="20" id="mark" name="mark"><br><br>
            <label for="course_id">Enter course id:</label><br>
            <input type="text" minlength="1" maxlength="40" id="course_id" name="course_id"><br><br>
            <input type="submit" value="Submit">
        </div>
    </form>
</div>

</body>
</html>
