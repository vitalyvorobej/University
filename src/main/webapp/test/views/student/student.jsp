<%--
  Created by IntelliJ IDEA.
  User: limee
  Date: 26.05.2020
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
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
            <input type="text" minlength="5" maxlength="40" id="student_name" name="student_name"><br>
            <label for="student_second_name">Enter second name:</label><br>
            <input type="text" minlength="5" maxlength="20" id="student_second_name" name="student_second_name"><br><br>
            <label for="user_table_id">Enter table id:</label><br>
            <input type="text" id="user_table_id" name="user_table_id"><br><br>
            <input type="submit" value="Submit">
        </center>
    </form>

</div>
</body>
</html>
--%>


<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-color: black;
        }

        * {
            box-sizing: border-box;
        }

        /* Add padding to containers */
        .container {
            padding: 16px;
            background-color: white;
        }

        /* Full-width input fields */
        input[type=text], input[type=password] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            display: inline-block;
            border: none;
            background: #f1f1f1;
        }

        input[type=text]:focus, input[type=password]:focus {
            background-color: #ddd;
            outline: none;
        }

        /* Overwrite default styles of hr */
        hr {
            border: 1px solid #f1f1f1;
            margin-bottom: 25px;
        }

        /* Set a style for the submit button */
        .registerbtn {
            background-color: #4CAF50;
            color: white;
            padding: 16px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
            opacity: 0.9;
        }

        .registerbtn:hover {
            opacity: 1;
        }

        /* Add a blue text color to links */
        a {
            color: dodgerblue;
        }

        /* Set a grey background color and center the text of the "sign in" section */
        .signin {
            background-color: #f1f1f1;
            text-align: center;
        }
    </style>
</head>
<body>

<form action="/studentServlet" method="post">
    <%--<input type="text" minlength="5" maxlength="40" id="student_name" name="student_name"><br>--%>
    <div class="container">
        <h1>Register</h1>
        <p>Please fill in this form to finish create an account.</p>
        <hr>

        <label for="student_name"><b>Name</b></label>
        <input type="text" placeholder="Enter name" name="student_name" id="student_name" required>

        <label for="student_second_name"><b>Second name</b></label>
        <input type="text" placeholder="Enter second name" name="student_second_name" id="student_second_name" required>

        <label for="user_table_id"><b>User id</b></label>
        <input type="text" placeholder="Enter id" name="user_table_id" id="user_table_id" required>
        <hr>
        <button type="submit" class="registerbtn">Register</button>
    </div>

<%--    <div class="container signin">
        <p>Already have an account? <a href="/test/views/login/login.jsp">Sign in</a>.</p>
    </div>--%>
</form>

</body>
</html>