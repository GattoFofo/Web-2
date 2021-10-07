<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2>Cadastro Ator</h2>
<form name="cadAtor" method="POST" action="cadAtor">
    Nome<br>
    <input type="text" name="nome" value=""><br>
    <input type="submit" value="OK">
</form>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>