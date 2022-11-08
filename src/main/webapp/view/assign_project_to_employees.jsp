<%@ page import="com.ideas2it.training.model.Project" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 10/18/2022
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
  <div id="project_details" >
    <form action="assign_project_to_employees",method="Get">
      <label for="employee_id"></label>
        <input type="text" name="project_id" id="project_id" placeholder="Project Id" required><br>
        <input type="submit" value="get_project">
    </form>
  </div>

  <%Project project = (Project) request.getAttribute("project");
  if (project != null) { %>

  <script>document.getElementById("project_details").style.visibility='hidden'</script>

  <div align="center">
    <p>${project}</p>
    <form action="assign_project_to_employees" method="POST">
      <label for="employee_id">Employee Ids to be assigned to a project</label><br>
      <input type="number" name="project_id" value="<%=project.getProjectId()%>" hidden>
        <div id="employee_ids">
          <input type="text" name="employee_id[]" id="employee_id" placeholder="Employee Id" required><br>
        </div>
        <input type="button" onclick="addEmployeeId()" value="add employee" align="center"><br>
        <input type="submit" value="ASSIGN" style="background-color: darkolivegreen ; color: darkorchid">
    </form>
    <p>${message}</p>
  </div>

  <% } else {%>

  <p>${message}</p>

  <%}%>



</body>
</html>

<script>
  function addEmployeeId() {
    let id1 = document.getElementById('employee_ids');
    var dummy = '<input type="text" name="employee_id[]" placeholder="Employee Id">\r\n<br>';
    var newspan = document.createElement('span');
    newspan.innerHTML += dummy;
    id1.appendChild(newspan);
  }
</script>