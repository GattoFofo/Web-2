<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<a href="Ator.jsp">Ator</a>
<h2>Cadastro Ator</h2>
<form action="cadAtor" method="post">
    Nome<br>
    <input type="text" name="nome" value=""><br>
    <input type="submit" name="action" value="save">
</form>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>