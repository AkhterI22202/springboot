<%@ page import="com.ideas2it.training.model.Employee" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>


<!DOCTYPE >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Real time info</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>
<div class="container">
    <table>

        <tr class="header">
            <td class="name">Name</td><td class="id">ID</td><td class="view-details">View Details</td>
        </tr>
        <%List<Employee> employees = (List<Employee>) request.getAttribute("employees");%>
        <% for ( Employee employee :employees)
        {
        %>

            <tr>
                <td class="name"><%=employee.getName()%></td>
                <td class="id"><%=employee.getEmployeeId()%></td>
                <td class="view-details">
                    <form action="/searchEmployee">
                        <input type="text" name="employeeId" value="<%=employee.getEmployeeId()%>" hidden>
                        <input type="submit" value="view" />
                    </form>
                </td>
<%--                <td class="view-details"></td>--%>
            </tr>

        <%}%>
    </table>
</div>
</body>
</html>

<style>
    table tr {
        border:1px solid black;
        background-color: bisque;

        padding:5px;

    }

    .header{
        font-weight: bold;
    }
    table{
        border:1px solid black;
        width:40em;

    }
    .name {
        position: relative;
        width:35%;
        display:flex;
        float:left;
    }
    .id {
        position: relative;
        width:35%;
        display:flex;
        float:left;
    }
    .view-details{
        display:flex;
        float:right;
        width: 20%;
    }



</style>