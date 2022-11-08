<%@ page import="com.ideas2it.training.model.Employee" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 10/12/2022
  Time: 10:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>inserting employee details into database</title>
</head>
<body>


    <form action="/updateMyEmployee" method="GET">
        <label for="employee_id">EmployeeId</label>
        <input type="text" name="employeeId" id="employee_id">
        <input type="submit" value="Get Employee">
    </form>


</body>
</html>
