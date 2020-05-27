<%--
  Created by IntelliJ IDEA.
  User: limee
  Date: 27.05.2020
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h1>CourseStudent Teacher Form</h1>
    <form action="/courseStudentServlet" method="post">
        <center>
            <label for="student_id">Enter student id:</label><br>
            <input type="text" minlength="1" maxlength="40" id="student_id" name="student_id" value=""><br>
            <label for="mark">Enter mark:</label><br>
            <input type="text" minlength="1" maxlength="20" id="mark" name="mark"
                   value=""><br><br>
            <label for="course_id">Enter course id:</label><br>
            <input type="text" id="course_id" name="course_id"
                   value=""><br><br>
            <input type="submit" value="Submit">
        </center>
    </form>

</div>
</body>
</html>
