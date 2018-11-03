<%--
  Created by IntelliJ IDEA.
  User: Vuqar
  Date: 10/15/2018
  Time: 10:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Style.css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</head>
<body>
    <div class="header"></div>
    <div class="container">
        <div class="nav">
            <button class="student" id="idStudentsButton">Students</button>
            <button class="teacher" id="idTeachersButton">Teachers</button>
            <button class="course" id="idCoursesButton">Courses</button>
        </div>
        <div class="main">
            <div id="idTable" hidden></div>
        </div>
    </div>
    <div class="footer"></div>
</body>
</html>
