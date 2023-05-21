<%--
  Created by IntelliJ IDEA.
  User: vietn
  Date: 5/20/2023
  Time: 6:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Add or update Student</h1>
    <form action="student" method="post">
        <label for="id">ID:(Update)</label>
        <input type="text" id="id" name="id">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name">
        <label for="age">Age:</label>
        <input type="text" id="age" name="age">
        <label for="address">Address:</label>
        <input type="text" id="address" name="address">
        <input type="submit" value="Submit">
    </form>
</body>
</html>
