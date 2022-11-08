<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 11/2/2022
  Time: 12:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div modelAttribute="leave">
   <p>{$message}</p>
  <table >
    <tr><td>LeaveId</td><td>${leave.leaveId}</td></tr>
    <tr><td>EmployeeId</td><td>${leave.employee.employeeId}</td></tr>
    <tr><td>StartDate</td><td>${leave.fromDate}</td></tr>
    <tr><td>EndDate</td><td>${leave.toDate}</td></tr>
    <tr><td>LeaveType</td><td>${leave.leaveType}</td></tr>
  </table>
  <form action="updateLeave">
        <input type="number" name="leaveId" value="${leave.leaveId}" hidden/>
        <input type="submit" value="Update Leave"/>
  </form>
  </div>
</body>
</html>
