<%--
  Created by IntelliJ IDEA.
  User: HP Victus
  Date: 5/24/2023
  Time: 11:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Student</title>
    <style>
        <%@include file="styles/style.css" %>
    </style>
</head>
<body>
<form action="employee" method="post" class="form">
    <label for="id">Id:</label>
    <input type="text" name="id" id="id" class="input">
    <label for="name">Name:</label>
    <input type="text" name="name" id="name" class="input">
    <button type="submit" class="submit-btn">Submit</button>
</form>
</body>
</html>
