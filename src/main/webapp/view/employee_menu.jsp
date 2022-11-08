<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 10/12/2022
  Time: 9:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/insertEmployee" method="get">Add Employee</a><br>
<a href="/searchEmployeePage">Search Employee</a><br>
<a href="update_employee.jsp">Update Employee</a><br>
<a href="delete_employee.jsp">Delete Employee</a><br>
<form method="get" action="/getEmployees">
    <input type="submit" value="Get Employees">
</form>

</body>
</html>
