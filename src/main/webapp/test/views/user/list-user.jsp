<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <%--<li><a href="<%=request.getContextPath()%>/courseServlet" class="nav-link">Users</a></li>--%>
</head>
<body>
<jsp:useBean id="l" scope="request" type="model.CourseModel"/>

<tr>
    ID: ${l.courseId} | Course_Name ${l.courseName} | Teacher_Id ${l.teacher.teacherId} |
    Course_Start_Date ${l.courseStartDate} | Course_END_Date ${l.courseEndDate}
</tr>
<%--<c:forEach items="${listCourse}" var="l" varStatus="loop">
    <td><c:out value="${l.courseId}"/></td>
    <c:out value="${l.courseName}"/>
    <c:out value="${l.teacherId}"/>
    <c:out value="${l.courseStartDate}"/>
    <c:out value="${l.courseEndDate}"/>
    &lt;%&ndash;${l.course_id}
    ${l.course_name}
    ${l.teacher_id}
    ${l.course_start_date}
    ${l.course_end_date}<br>&ndash;%&gt;
</c:forEach>--%>
</body>
</html>
