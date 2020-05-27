<%--
  Created by IntelliJ IDEA.
  User: limee
  Date: 26.05.2020
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h1>Student Form</h1>
    <form action="/studentServlet" method="post">
        <center>
            <label for="student_name">Enter name:</label><br>
            <input type="text" minlength="5" maxlength="40" id="student_name" name="student_name" value=""><br>
            <label for="student_second_name">Enter sec name:</label><br>
            <input type="text" minlength="5" maxlength="20" id="student_second_name" name="student_second_name"
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
