<%@ page import="com.ideas2it.training.model.LeaveRecords" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 10/12/2022
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<p>${message}</p>
      <form action="/insertLeave" modelAttribute="leave">
        <label>Employee Id</label><br>
        <input type="text" name="employeeId"  value="${leave.employee.employeeId}" required><br><br>
        <input type="text" name="leaveId"  value="${leave.leaveId}" hidden>
        <label>From Date</label><br>
        <input type="date" name="fromDate" value="${leave.fromDate}" required><br><br>
        <label>To Date</label><br>
        <input type="date" name="toDate" value="${leave.toDate}" required><br><br>
        <label>Leave Type</label><br>
        <select name="leaveType" value="${leave.leaveType}" required>
          <option value="Casual">Casual</option>
          <option value="Sick">Sick</option>
          <option value="Medical">Medical</option>
        </select><br><br>
        <input type="submit"  id="submit">
      </form>
</body>
</html>

<style>
  #submit {
    background-color: aquamarine;
    color: black;
  }

</style>