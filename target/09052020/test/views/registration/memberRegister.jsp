<%--
  Created by IntelliJ IDEA.
  User: limee
  Date: 17.05.2020
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <style>
        body {
            background-image: url("http://www.baltana.com/files/wallpapers-4/Rain-Background-HQ-Desktop-Wallpaper-14526.jpg");
            /*background-image: url("https://ru.freeimages.com/photo/bokeh-background-in-light-tan-rose-1635915");*/
        }
    </style>
    <title> Register form</title>
</head>
<body>
<%--<form action="register" method="post">
    <tr>
        <td>Login</td>
    </tr>
    <input type="text" name="login">
    <tr>
        <td>password</td>
    </tr>
    <input type="password" name="password">
    <tr>
        <td>role</td>
    </tr>
    <input type="text" name="role">
    <input type="submit" value="register">
</form>--%>

<center><h3>Create your account with simple registration</h3></center>

<form action="/registerServlet<%--test/views/login/login.jsp--%>" method="post">
    <center>
        <label for="Login">Enter Login:</label><br>
        <input type="text" minlength="5" maxlength="40" id="login" name="login" value=""><br>
        <label for="password">Enter password:</label><br>
        <input type="password" minlength="5" maxlength="20" id="password" name="password" value=""><br><br>
        <label for="role">Enter role:</label><br>
        <input type="text" minlength="5" maxlength="10" id="role" name="role" value="1"><br><br>
        <input type="submit" value="Submit">
    </center>
</form>
<center><p>If you click the "Submit" button, the form-data will be sent to a page called "/action_page.php".</p>
</center>


</body>
</html>
