<%@ page import="com.ideas2it.training.model.Employee" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 11/1/2022
  Time: 5:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%Employee employee= (Employee)request.getAttribute("employee");%>
  <form>
    <input type="text" value="${employee.getName()}" readonly/>
    <input type="text" value="${employee.getEmployeeId()}" readonly />
    <input type="text" value="${employee.birthdate}" readonly />
    <input type="text" value="${employee.contact}" readonly />
    <input type="text" value="${employee.designation}" readonly />
    <input type="text" value="${employee.email}" readonly />
    <input type="text" value="${employee.gender}" readonly />
  </form>
    <form action="/updateMyEmployee">
      <input type="text" name="employeeId" value="${employee.employeeId}" hidden/>
      <input type="submit" value = "update"/>
    </form>

    <form action="/deleteEmployee">
      <input type="text" name="employeeId" value="${employee.employeeId}" hidden/>
      <input type="submit" value = "delete"/>
    </form>




</body>
</html>
