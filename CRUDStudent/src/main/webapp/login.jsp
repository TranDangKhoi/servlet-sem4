<%--
  Created by IntelliJ IDEA.
  User: vietn
  Date: 5/20/2023
  Time: 6:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login</title>
</head>
<body>

<c:if test="${fail != null}">
    <span style="color: red">${fail}</span>
</c:if>

<form action="login" method="post">
<label for="username">Username:</label>
<input id="username" name="username" type="text">
<label for="password">Password:</label>
<input id="password" type="password" name = "password">
<input type="submit" value="submit">
</form>
<h1>Do you haven't account?<a href="register">Register</a></h1>
</body>
</html>
