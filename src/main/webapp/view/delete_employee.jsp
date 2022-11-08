<%@ page import="com.ideas2it.training.model.Employee" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 10/17/2022
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
  <div id="get_employee">
    <form action="/deleteEmployee" method="GET">
      <label for="employee_id">Employee Id</label>
      <input type="text" name="employeeId" id="employee_id">
      <input type="submit" value="Get Employee">
    </form>
  </div>

</body>
</html>
