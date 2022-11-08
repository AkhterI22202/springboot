<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<p>${message}</p>
<a href="/employeeMenu">Employee</a><br><br>
<a href="/leaveMenu">Leaves</a><br><br>
<a href="projects_menu.jsp">Projects</a><br><br>
<a href="assign_project_to_employees.jsp">Assign Project to employees</a><br><br>
</body>
</html>