<%@ page import="com.ideas2it.training.model.LeaveRecords" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 11/2/2022
  Time: 12:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% List<LeaveRecords> leaves =(List<LeaveRecords>) request.getAttribute("leaves"); %>
    <table>
        <th>
            <td>Start date</td><td>End Date</td><td>View</td>
        </th>
        <% for(LeaveRecords leave:leaves) { %>
            <tr>
                <td><%=leave.getFromDate()%></td>
                <td><%=leave.getToDate()%></td>
<%--                <td><button onclick="location.href='getLeave?leaveId=<%=leave.getLeaveId()%>'">view</button>--%>
                <td>
                    <form action="/getLeave">
                        <input type="number" name="leaveId" value=<%=leave.getLeaveId()%> hidden/>
                        <input type="submit" value="view"/>
                    </form>
                </td>
            </tr>

        <%}%>
    </table>
</body>
</html>
