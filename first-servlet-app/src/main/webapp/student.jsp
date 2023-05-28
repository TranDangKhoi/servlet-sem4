<%@ page import="java.util.List" %>
<%@ page import="com.example.firstservletapp.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: HP Victus
  Date: 5/26/2023
  Time: 9:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student List</title>
    <style>
        <%@include file="styles/style.css" %>
    </style>
</head>
<body>
<table>
    <thead>
    <th>Id</th>
    <th>Name</th>
    <th>Action</th>
    </thead>
    <tbody>
    <% List<Student> studentList = (List<Student>) request.getAttribute("studentList");
        if (studentList != null) {
            for (Student student : studentList) { %>
    <tr>
        <td><%= student.getId() %>
        </td>
        <td><%= student.getName() %>
        </td>
        <td>Delete | Edit</td>
    </tr>
    <% }
    } %>
    </tbody>
</table>
</body>
</html>
