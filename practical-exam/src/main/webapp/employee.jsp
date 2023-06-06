<%@ page import="java.util.List" %>
<%@ page import="com.example.firstservletapp.entity.Employee" %>
<%@ page import="com.example.firstservletapp.entity.Employee" %><%--
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
<a href="create.jsp">Create new employee</a>
<table>
    <thead>
    <th>Id</th>
    <th>Name</th>
    <th>Action</th>
    </thead>
    <tbody>
    <% List<Employee> employeeList = (List<Employee>) request.getAttribute("employeeList");
        if (employeeList != null) {
            for (Employee employee : employeeList) { %>
    <tr>
        <td><%= employee.getId() %>
        </td>
        <td><%= employee.getName() %>
        </td>
        <td>Delete | Edit</td>
    </tr>
    <% }
    } %>
    </tbody>
</table>
</body>
</html>
