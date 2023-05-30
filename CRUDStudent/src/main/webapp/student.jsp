<%@ page import="com.example.loginsvl.entity.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: vietn
  Date: 5/20/2023
  Time: 6:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <style><%@include file="WEB-INF/style/style.css" %></style>
    <style><%@include file="WEB-INF/style/student.css" %></style>
</head>
<body>
<table >
    <h1 class="text-title">All Student</h1>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
        <c:when test="${listStudent.size() > 0}">
            <c:forEach items="${listStudent}" var="student" varStatus="loop">
                <tr>
                    <th>${loop.index +1}</th>
                    <td>${student.name}</td>
                    <td>${student.age}</td>
                    <td>${student.address}</td>
                    <td>
                        <form class="form" action="updateStudent.jsp" method="post" accept-charset="UTF-8">
                            <input type="hidden" name="studentId" value="${student.id}"/>
                            <input type="hidden" name="studentName" value="${student.name}"/>
                            <input type="hidden" name="studentAge" value="${student.age}"/>
                            <input type="hidden" name="studentAddress" value="${student.address}"/>
                            <button type="submit">UPDATE</button>
                        </form>
                    </td>
                    <td>
                        <form action="student" method="post">
                            <input type="hidden" name="idStu" value="${student.id}">
                            <button type="submit" name="method" value="DELETE">DELETE</button>
                        </form>
                    </td>

                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <h1>Don't Having Student</h1>
        </c:otherwise>
    </c:choose>
    </tbody>
</table>
<h1 class="text-title">Add Student</h1>
<form action="student" method="post">
    <div class="form-input">
        <label class="label-text" for="name">Name:</label>
        <input class="form input" type="text" id="name" name="name">
    </div>
    <div class="form-input">
        <label class="label-text" for="age">Age:</label>
        <input class="form input" type="text" id="age" name="age">
    </div>
    <div class="form-input">
        <label class="label-text" for="address">Address:</label>
        <input class="form input" type="text" id="address" name="address">
    </div>

    <input class=" submit-btn" type="submit" name="method" value="Submit">
</form>
</body>
</html>
