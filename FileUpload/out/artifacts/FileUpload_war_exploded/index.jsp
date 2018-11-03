<%--
  Created by IntelliJ IDEA.
  User: Vuqar
  Date: 10/29/2018
  Time: 12:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>File Upload</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form method="POST" action="upload" enctype="multipart/form-data" >
    File:
    <input type="file" name="file" id="file" /> <br/>
    Destination:
    <input type="text" value="/tmp" name="destination"/>
    </br>
    <img src="${pageContext.request.contextPath}/load.gif" alt="">
    <input type="submit" value="Upload" name="upload" id="upload" />
</form>
</body>
</html>
