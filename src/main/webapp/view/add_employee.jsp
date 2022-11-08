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

<header>
    Ideas2It
</header>
<section>
    <div id="container">
        <label >Employee Register Form</label>

        <form action="/insertEmployeeData" modelAttribute="employee" method="get">
            <div id="form-div">
                <input type="text" name="employeeId" value="${employee.employeeId}" hidden/>
                <div class="input-divs">
                    <label for="employee_name">Name</label>
                    <input type="text" name="name" value="${employee.name}" placeholder="Name" class="input" id="employee_name"
                           pattern="[A-Z][a-z]*([ ]{0,1}[a-z])*" required>
                </div>
                <div class="input-divs">
                    <label for="contact">Contact</label>
                    <input class="input" id="contact" type="text" name="contact" placeholder="Contact" value="${employee.contact}" required
                           pattern="[6-9]{2}[0-9]{8}"
                           title="contact number Should be exactly 10 digits and starting 2 digits should be 6-9">
                </div>
                <div class="input-divs">
                    <label for="email">Email</label>
                    <input class="input" value="${employee.email}" id="email" type="email" name="email" placeholder="Email" required><br>
                </div>
                <div class="input-divs">
                    <label for="employee_type">Type</label>
                    <select name="employeeType" id="employee_type" class="input" style="color: black; background-color: white;">
                        <option value="Trainer">Trainer</option>
                        <option value="Trainee">Trainee</option>
                    </select>
                </div>
                <div class="input-divs">
                    <label for="gender">Gender</label>
                    <select class="input" value="${employee.gender}" id="gender" name="gender" style="color: black; background-color: white;">
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                        <option value="Other">Other</option>
                    </select>
                </div>
                <div class="input-divs">
                    <label for="birthdate">Birthdate</label>
                    <input class="input" value="${employee.birthdate}" id="birthdate" type="date"  name="birthdate" placeholder="DOB" required><br>
                </div>
                <div class="input-divs">
                    <label for="designation">Designation</label>
                    <input class="input" value="${employee.designation}" id="designation" type="text" name="designation" placeholder="Designation" required>
                </div>
                <div class="input-divs">
                    <label for="probation">Probattion</label>
                    <input class="input" value="${employee.probationTime}" id="probation" type="text" name="probationTime" placeholder="Probation" required><br>
                </div>
            </div>
            <div class="submit-div">
                <input class="submit-button" type="submit" ></input>
            </div>
        </form>

    </div>

</section>
</body>
</html>

<style>
    header{
        width:100%;
        height:100px;
        color:aliceblue;
        font-size: 2em;
        padding:10px;
    }
    .submit-button{
        background-color:lightgreen;
        border: 2ch;
        border-radius: 5px;
        width:9em;
        height:3em;
        font-size: 1em;
        margin: 2em;;


    }
    input{
        background-color: cadetblue;
        font-family: serif;
        position: relative;
    }
    .input{
        background-color: transparent;
        font-family: serif;
        border-radius: 5px;
        border:1px solid blue;
        color:cornsilk;
        margin:2em;
    }
    body{
        background-image: url("https://www.pixelstalk.net/wp-content/uploads/2016/05/Laptop-Wallpapers-Black-HD.jpg");
    }

    label{

        font-size: 1.4em;
        color:white;


    }
    form{
        margin-top:1em;
        color:white;
    }
    .submit-button:hover{
        background-color: blue;
    }
    .input-divs {
        width: 300px;
        height:100px;
        display:flex;
        float:left;
        margin:1em;
        margin:auto;
    }

    section{
        text-align: center;
    }
</style>






<%--<form action="employee" method="post">--%>
<%--    <label>Employee Type</label>--%>
<%--    <select name="employee_type" >--%>
<%--        <option value="Trainer">Trainer</option>--%>
<%--        <option value="Trainee">Trainee</option>--%>
<%--    </select>--%>
<%--    <br><br>--%>
<%--    <input type="text" name="employee_name" placeholder="Employee name" pattern="[A-Z][a-z]*([ ]{0,1}[a-z])*" required>--%>
<%--    <br><br>--%>
<%--    <select name="gender" >--%>
<%--        <option value="Male">Male</option>--%>
<%--        <option value="Female">Female</option>--%>
<%--        <option value="Other">Other</option>--%>
<%--    </select>--%>
<%--    <br><br>--%>
<%--    <input type="date"  name="birthdate" placeholder="DOB" required><br><br>--%>
<%--    <input type="text" name="designation" placeholder="Designation" required><br><br>--%>
<%--    <input type="number" name="contact" placeholder="Contact" pattern="[6-9]{2}[0-9]{8}" required><br><br>--%>
<%--    <input type="email" name="email" placeholder="Email" required><br><br>--%>
<%--    <input type="text" name="probation" placeholder="Probation" required>--%>
<%--    <br><br>--%>
<%--    <input type="submit" >--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
