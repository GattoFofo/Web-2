<%@ page import="jakarta.persistence.EntityManagerFactory" %>
<%@ page import="jakarta.persistence.Persistence" %>
<%@ page import="jakarta.persistence.EntityManager" %>
<%@ page import="jakarta.persistence.criteria.CriteriaBuilder" %>
<%@ page import="model.Classe" %>
<%@ page import="jakarta.persistence.criteria.CriteriaQuery" %>
<%@ page import="jakarta.persistence.criteria.Root" %>
<%@ page import="jakarta.persistence.TypedQuery" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: gu12p
  Date: 14/10/2021
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Classe</title>
</head>
<body>
<a href="index.jsp">Index</a>
<table>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Valor</th>
        <th>Devolução</th>
    </tr>

    <tr>
        <form action="Classe" method="post">
            <td>new</td>
            <td><input type="text" name="nome" value=""></td>
            <td><input type="number" name="valor" value="" step="0.01"></td>
            <td><input type="date" name="devolucao" value=""></td>
            <td><input type="submit" name="action" value="save"></td>
        </form>
    </tr>

    <%
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Classe> query = builder.createQuery(Classe.class);
        Root<Classe> atorRoot = query.from(Classe.class);
        query.select(atorRoot);
        TypedQuery<Classe> atorTypedQuery = manager.createQuery(query);
        List<Classe> results = atorTypedQuery.getResultList();

        for (Classe classe : results) {
    %>
    <tr>
        <form action="Classe" method="post">
            <td><input type="number" name="id" value="<%=classe.getId()%>" readonly></td>
            <td><input type="text" name="nome" value="<%=classe.getNome()%>"></td>
            <td><input type="number" name="valor" value="<%=classe.getValor()%>" step="0.01"></td>
            <td><input type="date" name="devolucao" value="<%=format.format(classe.getDevolucao())%>"></td>
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
