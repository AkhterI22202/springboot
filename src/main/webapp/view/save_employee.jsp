<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 10/31/2022
  Time: 7:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <form:form action="/insertEmployee" modelAttribute="employee">
            <
            <input path="name" type="text" name="name" value="${employee.name}"/>
            <input type="submit" />

        </form:form>
    </div>
</body>
</html>
