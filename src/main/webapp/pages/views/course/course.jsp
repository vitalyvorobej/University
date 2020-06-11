<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Course Registration</title>
</head>
<body>
<div align="center">
    <h1>Register new course form</h1>
    <form action="<c:url value="/CreateCourse"/>" method="post">
        <div style="text-align: center;">
            <label for="course_name">Enter course name:</label><br>
            <input type="text" minlength="5" maxlength="40" id="course_name" name="course_name" value=""><br>
            <label for="teacher_id">Enter teacher id:</label><br>
            <input type="text" minlength="1" maxlength="20" id="teacher_id" name="teacher_id"
                   value=""><br><br>
            <label for="course_start_date">Enter course start date:</label><br>
            <input type="date" id="course_start_date" name="course_start_date"
                   value=""><br><br>
            <label for="course_end_date">Enter course end date:</label><br>
            <input type="date" id="course_end_date" name="course_end_date"
                   value=""><br><br>
            <input type="submit" value="Submit">
        </div>
    </form>

</div>
</body>
</html>
