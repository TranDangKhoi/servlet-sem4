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
    <style><%@include file="WEB-INF/style/style.css" %></style>
    <style><%@include file="WEB-INF/style/student.css" %></style>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<form class="form" action="student" method="post" accept-charset="UTF-8">
    <div class="form-input">
        <input class="input" type="hidden" name="id" value="<%= request.getParameter("studentId")%>">
        <label class="label-text" for="name">Name:</label>
        <input class="input form"  type="text" id="name" name="name" value="<%=request.getParameter("studentName") %>">

    </div>
    <div class="form-input">
        <label class="label-text" for="age">Age:</label>
        <input class="input form"  type="text" id="age" name="age" value="<%=request.getParameter("studentAge") %>">
    </div>
    <div class="form-input">
        <label class="label-text" for="address">Address:</label>
        <input class="input form"   type="text" id="address" name="address" value="<%=request.getParameter("studentAddress") %>">
    </div>
    <button class="submit-btn" type="submit" name="method" value="update"> Update</button>
    <a class="form-input" href="student">Cancel</a>
</form>
</body>
</html>
