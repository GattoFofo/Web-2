<%@ page import="jakarta.persistence.EntityManagerFactory" %>
<%@ page import="jakarta.persistence.Persistence" %>
<%@ page import="jakarta.persistence.EntityManager" %>
<%@ page import="jakarta.persistence.criteria.CriteriaBuilder" %>
<%@ page import="jakarta.persistence.criteria.CriteriaQuery" %>
<%@ page import="model.Ator" %>
<%@ page import="jakarta.persistence.criteria.Root" %>
<%@ page import="jakarta.persistence.TypedQuery" %>
<%@ page import="java.util.List" %>
<%--
Created by IntelliJ IDEA.
User: gu12p
Date: 07/10/2021
Time: 14:16
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ator</title>
</head>
<body>
<a href="index.jsp">Index</a>
<table>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Action</th>
    </tr>

    <tr>
        <form action="cadAtor" method="post">
            <td>new</td>
            <td><input type="text" name="nome" value=""></td>
            <td><input type="submit" name="action" value="save"></td>
        </form>
    </tr>

    <%
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Ator> query = builder.createQuery(Ator.class);
        Root<Ator> atorRoot = query.from(Ator.class);
        query.select(atorRoot);
        TypedQuery<Ator> atorTypedQuery = manager.createQuery(query);
        List<Ator> results = atorTypedQuery.getResultList();

        for (Ator ator : results) {
    %>
    <tr>
        <form action="cadAtor" method="post">
            <td><input type="number" name="id" value="<%=ator.getId()%>" readonly></td>
            <td><input type="text" name="nome" value="<%=ator.getName()%>"></td>
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
