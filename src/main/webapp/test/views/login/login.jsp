<%--
  Created by IntelliJ IDEA.
  User: limee
  Date: 19.05.2020
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<div class="w3-container">
    <div style="text-align: center;"><h2>Sign in Page</h2>
        <%-- <div class="topnav">
             <a href="/test/views/index.jsp">Home</a>
         </div>--%>

        <button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-black w3-large">
            GO
        </button>
    </div>
    <div id="id01" class="w3-modal">
        <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">


            <form class="w3-container" action="/login" method="post">
                <div class="w3-section">
                    <label><b>Username</b></label>
                    <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter login"
                           name="login" required>
                    <label><b>Password</b></label>
                    <input class="w3-input w3-border" type="password" placeholder="Enter Password" name="password"
                           required>
                    <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">Login</button>
                </div>
                <tr>
                    <td><span
                            style="color:#ff0000"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>
                    </td>
                </tr>
            </form>

            <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
                <button onclick="document.getElementById('id01').style.display='none'" type="button"
                        class="w3-button w3-red">Cancel
                </button>
                <%--<span class="w3-right w3-padding w3-hide-small">Forgot <a href="#">password?</a></span>--%>
            </div>
        </div>
    </div>
</div>
</body>
</html>