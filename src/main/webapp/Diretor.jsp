<%@ page import="model.Diretor" %>
<%@ page import="jakarta.persistence.EntityManagerFactory" %>
<%@ page import="jakarta.persistence.Persistence" %>
<%@ page import="jakarta.persistence.EntityManager" %>
<%@ page import="jakarta.persistence.criteria.CriteriaBuilder" %>
<%@ page import="jakarta.persistence.criteria.CriteriaQuery" %>
<%@ page import="jakarta.persistence.criteria.Root" %>
<%@ page import="jakarta.persistence.TypedQuery" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: gu12p
  Date: 14/10/2021
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Diretor</title>
</head>
<body>
<a href="index.jsp">Index</a>
<table>
    <tr>
        <th>ID</th>
        <th>Nome</th>
    </tr>

    <tr>
        <form action="DiretorServlet" method="post">
            <td>new</td>
            <td><input type="text" name="nome" value=""></td>
            <td><input type="submit" name="action" value="save"></td>
        </form>
    </tr>

    <%
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Diretor> query = builder.createQuery(Diretor.class);
        Root<Diretor> atorRoot = query.from(Diretor.class);
        query.select(atorRoot);
        TypedQuery<Diretor> atorTypedQuery = manager.createQuery(query);
        List<Diretor> results = atorTypedQuery.getResultList();

        for (Diretor diretor : results) {
    %>
    <tr>
        <form action="DiretorServlet" method="post">
            <td><input type="number" name="id" value="<%=diretor.getId()%>" readonly></td>
            <td><input type="text" name="nome" value="<%=diretor.getNome()%>"></td>
            <td><input type="submit" name="action" value="delete"></td>
            <td><input type="submit" name="action" value="update"></td>
        </form>
    </tr>
    <%
        }
        manager.close();
        factory.close();
    %>
</table>
</body>
</html>
