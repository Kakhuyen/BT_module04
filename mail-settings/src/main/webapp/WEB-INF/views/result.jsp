<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Result</title>
</head>
<body>

<h1>Updated Settings</h1>

<p>Language: ${settings.language}</p>
<p>Page Size: ${settings.pageSize}</p>
<p>Spam Filter: ${settings.spamFilter}</p>
<p>Signature:</p>
<p>${settings.signature}</p>

<a href="settings">Back</a>

</body>
</html>