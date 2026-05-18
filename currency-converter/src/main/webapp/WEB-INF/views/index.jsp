<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <title>Currency Converter</title>

</head>

<body>

<h1>Currency Converter</h1>

<form action="/convert" method="get">

    <label>USD:</label>

    <input type="number" name="usd">

    <br><br>

    <label>Rate:</label>

    <input type="number" name="rate">

    <br><br>

    <button type="submit">

        Convert

    </button>

</form>

</body>

</html>