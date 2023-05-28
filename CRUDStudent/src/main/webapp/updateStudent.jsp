<%@ page import="com.example.loginsvl.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: vietn
  Date: 5/26/2023
  Time: 10:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<form action="student" method="post" accept-charset="UTF-8">
    <input type="hidden" name="id" value="<%= request.getParameter("studentId")%>">
    <label for="name">Name:</label>
    <input class="form-input" type="text" id="name" name="name" value="<%=request.getParameter("studentName") %>">
    <label for="age">Age:</label>
    <input class="form-input" type="text" id="age" name="age" value="<%=request.getParameter("studentAge") %>">
    <label for="address">Address:</label>
    <input class="form-input" type="text" id="address" name="address" value="<%=request.getParameter("studentAddress") %>">
    <button type="submit" name="method" value="update"> Update</button>
</form>
</body>
</html>
