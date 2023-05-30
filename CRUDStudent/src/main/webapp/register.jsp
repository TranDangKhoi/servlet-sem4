<%--
  Created by IntelliJ IDEA.
  User: vietn
  Date: 5/27/2023
  Time: 7:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% String check = (String) request.getAttribute("password");
    String checkUsername = (String) request.getAttribute("username");
%>
<form action="register" method="post">
    <div>
        <label for="username">Username:</label>
        <input id="username" type="text" name="username" >
        <c:choose>
            <c:when test="${checkUsername != null }">
                <span>${checkUsername}</span>
            </c:when>
        </c:choose>
    </div>
    <div>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password">
        <c:choose>
            <c:when test="${check != null}">
                <span>${check}</span>
            </c:when>
        </c:choose>
    </div>
    <div>
        <label for="passwordConfirm">Confirm Password:</label>
        <input type="password" id="passwordConfirm" name="confirm">
        <c:choose>
            <c:when test="${check != null}">
                <span>${check}</span>
            </c:when>
        </c:choose>
    </div>
    <div>
        <button type="submit">Register</button>
    </div>
</form>
</body>
</html>
