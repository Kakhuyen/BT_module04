<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>

<html>

<head>
    <title>Customers List</title>
</head>

<body>

<h1>Customers List</h1>

<table border="1">

    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>

    <c:forEach var="c"
               items="${customers}">

        <tr>

            <td>${c.id}</td>

            <td>

                <a href="${pageContext.request.contextPath}/customers/${c.id}">

                        ${c.name}

                </a>

            </td>

            <td>${c.email}</td>

            <td>${c.address}</td>

        </tr>

    </c:forEach>

</table>

</body>

</html>