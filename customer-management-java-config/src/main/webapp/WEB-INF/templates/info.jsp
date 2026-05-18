<%@ page contentType="text/html;charset=UTF-8" %>

<html>

<head>
    <title>Customer Info</title>
</head>

<body>

<form method="post"
      action="${pageContext.request.contextPath}/customers/update">

    <input type="hidden"
           name="id"
           value="${customer.id}">

    <p>
        Name:
        <input type="text"
               name="name"
               value="${customer.name}">
    </p>

    <p>
        Email:
        <input type="text"
               name="email"
               value="${customer.email}">
    </p>

    <p>
        Address:
        <input type="text"
               name="address"
               value="${customer.address}">
    </p>

    <button>

        Update

    </button>

</form>

<p>

    <a href="${pageContext.request.contextPath}/customers">

        Back to list

    </a>

</p>

</body>

</html>