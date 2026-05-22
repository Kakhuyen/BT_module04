<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Settings</title>
</head>
<body>

<h1>Settings</h1>

<form:form action="update" method="post" modelAttribute="settings">

    <table>

        <tr>
            <td>Languages</td>
            <td>
                <form:select path="language">
                    <form:options items="${languages}"/>
                </form:select>
            </td>
        </tr>

        <tr>
            <td>Page Size:</td>
            <td>
                Show
                <form:select path="pageSize">
                    <form:options items="${pageSizes}"/>
                </form:select>
                emails per page
            </td>
        </tr>

        <tr>
            <td>Spams filter:</td>
            <td>
                <form:checkbox path="spamFilter"/>
                Enable spams filter
            </td>
        </tr>

        <tr>
            <td>Signature:</td>
            <td>
                <form:textarea path="signature" rows="5" cols="30"/>
            </td>
        </tr>

        <tr>
            <td></td>
            <td>
                <input type="submit" value="Update"/>
                <input type="reset" value="Cancel"/>
            </td>
        </tr>

    </table>

</form:form>

</body>
</html>