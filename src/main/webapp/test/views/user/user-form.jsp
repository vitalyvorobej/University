<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a> User Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${userTableModel != null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${userTableModel == null}">
                <form action="insert" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${userTableModel != null}">
                                Edit User
                            </c:if>
                            <c:if test="${userTableModel == null}">
                                Add New User
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${userTableModel != null}">
                        <input type="hidden" name="user_table_id"
                               value="<c:out value='${userTableModel.user_table_id}' />"/>
                    </c:if>

                    <fieldset class="form-group">
                        <label>User login</label> <input type="text" value="<c:out value='${userTableModel.login}' />"
                                                         class="form-control" name="login" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>User password</label> <input type="text"
                                                            value="<c:out value='${userTableModel.password}' />"
                                                            class="form-control" name="text">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>User role</label> <input type="text" value="<c:out value='${userTableModel.role}' />"
                                                        class="form-control" name="role">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>

</html>