<%--
  Created by IntelliJ IDEA.
  User: VICTUS
  Date: 5/18/2026
  Time: 2:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <title>Email Validator</title>

</head>

<body>

<h1>Email Validate</h1>

<h3 style="color:red">

    ${message}

</h3>

<form action="validate" method="post">

    <input type="text"
           name="email"
           placeholder="Enter email to validate">

    <br><br>

    <input type="submit"
           value="Validate">

</form>

</body>

</html>
