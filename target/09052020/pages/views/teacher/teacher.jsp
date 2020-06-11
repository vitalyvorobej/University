<%--
  Created by IntelliJ IDEA.
  User: limee
  Date: 22.05.2020
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<div align="center">
    <h1>Teacher Register Form</h1>
    <form action="/TeacherServlet" method="post">
        <center>
            <label for="teacher_name">Enter name:</label><br>
            <input type="text" minlength="5" maxlength="40" id="teacher_name" name="teacher_name" value=""><br>
            <label for="teacher_second_name">Enter sec name:</label><br>
            <input type="text" minlength="5" maxlength="20" id="teacher_second_name" name="teacher_second_name"
                   value=""><br><br>
            <label for="user_table_id">Enter table id:</label><br>
            <input type="text" id="user_table_id" name="user_table_id"
                   value=""><br><br>
            <input type="submit" value="Submit">
        </center>
    </form>

</div>
</body>
</html>