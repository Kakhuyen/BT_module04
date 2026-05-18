<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Calculator</title>
</head>

<body>

<h2>Simple Calculator</h2>

<form action="/calculate" method="post">

    First Number:

    <input type="number"
           name="number1"
           step="any">

    <br><br>

    Second Number:

    <input type="number"
           name="number2"
           step="any">

    <br><br>

    <button type="submit"
            name="operator"
            value="+">

        Addition(+)

    </button>

    <button type="submit"
            name="operator"
            value="-">

        Subtraction(-)

    </button>

    <button type="submit"
            name="operator"
            value="*">

        Multiplication(*)

    </button>

    <button type="submit"
            name="operator"
            value="/">

        Division(/)

    </button>

</form>

<h3>

    Result: ${result}

</h3>

</body>
</html>