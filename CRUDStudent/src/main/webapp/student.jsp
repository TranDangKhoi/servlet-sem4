<%@ page import="com.example.loginsvl.entity.Student" %>
<%@ page import="java.util.List" %><%--
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
    <link type="text/css" href="WEB-INF/style/Student.css">
</head>
<body>
<table border="1px solid #888" width="100%" align="center">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <% request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        List<Student> list = (List<Student>) request.getAttribute("listStudent");
        for (int i = 0; i < list.size(); i++) {
    %>
    <tr>
        <td><%= list.get(i).getId()%>
        </td>
        <td><%= list.get(i).getName()%>
        </td>
        <td><%= list.get(i).getAge()%>
        </td>
        <td><%= list.get(i).getAddress()%>
        </td>
        <td>
            <form action="updateStudent.jsp" method="post" accept-charset="UTF-8">
                <input type="hidden" name="studentId" value="<%= list.get(i).getId()%>"/>
                <input type="hidden" name="studentName" value="<%= list.get(i).getName()%>"/>
                <input type="hidden" name="studentAge" value="<%= list.get(i).getAge()%>"/>
                <input type="hidden" name="studentAddress" value="<%= list.get(i).getAddress()%>"/>
                <button type="submit">UPDATE</button>
            </form>
        </td>
        <td>
            <form action="student" method="post">
                <input type="hidden" name="idStu" value=<%=list.get(i).getId()%>>
                <input type="submit" name="method" value="DELETE">
            </form>
        </td>

    </tr>
    <% }%>
    <td></td>
    </tbody>
</table>
<h1>Add Student</h1>
<form action="student" method="post">
    <label for="name">Name:</label>
    <input class="form-input" type="text" id="name" name="name">
    <label for="age">Age:</label>
    <input class="form-input" type="text" id="age" name="age">
    <label for="address">Address:</label>
    <input class="form-input" type="text" id="address" name="address">

    <input type="submit" name="method" value="Submit">
</form>
</body>
</html>
