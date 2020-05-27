<%--
  Created by IntelliJ IDEA.
  User: limee
  Date: 20.05.2020
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Page</title>
</head>
<% //In case, if Editor session is not set, redirect to Login page
    if((request.getSession(false).getAttribute("Student")== null) )
    {
%>
<jsp:forward page="/test/views/index.jsp"></jsp:forward>
<%} %>
<body>
<center><h2>Student Home</h2></center>

Welcome <%=request.getAttribute("login") %>

<div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>

</body>
</html>
