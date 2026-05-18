<%--
  Created by IntelliJ IDEA.
  User: VICTUS
  Date: 5/18/2026
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Result</title>
</head>

<body>

<h2>Selected Condiments:</h2>

<%
    String[] list =
            (String[]) request.getAttribute("condiments");

    if (list != null) {

        for (String s : list) {

            out.println(s + "<br>");

        }

    } else {

        out.println("No condiment selected");

    }
%>

</body>
</html>
