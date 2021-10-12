<%@ page import="jakarta.persistence.EntityManagerFactory" %>
<%@ page import="jakarta.persistence.Persistence" %>
<%@ page import="jakarta.persistence.EntityManager" %>
<%@ page import="jakarta.persistence.criteria.CriteriaBuilder" %>
<%@ page import="jakarta.persistence.criteria.CriteriaQuery" %>
<%@ page import="model.Ator" %>
<%@ page import="jakarta.persistence.criteria.Root" %>
<%@ page import="jakarta.persistence.TypedQuery" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
Created by IntelliJ IDEA.
User: gu12p
Date: 07/10/2021
Time: 14:16
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Action</th>
    </tr>

    <%
        Ator ator;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Ator> query = builder.createQuery(Ator.class);
        Root<Ator> atorRoot = query.from(Ator.class);
        query.select(atorRoot);
        TypedQuery<Ator> atorTypedQuery = manager.createQuery(query);
        List<Ator> results = atorTypedQuery.getResultList();

        Iterator<Ator> iterator = results.iterator();
        int i;

        while (iterator.hasNext()) {
            ator = iterator.next();

            out.println(
                    "<tr>" +
                        "<td>");
            i = ator.getId();
            out.println(
                    i +
                        "</td>" +
                        "<td>" +
                            ator.getName() +
                        "</td>" +
                        "<td>" +
                            "<form action=\"cadAtor\" method=\"post\">\n" +
                            "        <input type=\"hidden\" name=\"id\" value=\""+i+"\">\n" +
                            "        <input type=\"submit\" name=\"action\" value=\"delete\">\n" +
                            "    </form>" +
                        "</td>" +
                    "</tr>");
        }
    %>
</table>
</body>
</html>
