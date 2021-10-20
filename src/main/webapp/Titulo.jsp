<%@ page import="model.Ator" %>
<%@ page import="jakarta.persistence.EntityManagerFactory" %>
<%@ page import="jakarta.persistence.Persistence" %>
<%@ page import="jakarta.persistence.EntityManager" %>
<%@ page import="jakarta.persistence.criteria.CriteriaBuilder" %>
<%@ page import="jakarta.persistence.criteria.CriteriaQuery" %>
<%@ page import="jakarta.persistence.criteria.Root" %>
<%@ page import="jakarta.persistence.TypedQuery" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Diretor" %>
<%@ page import="model.Classe" %>
<%@ page import="model.Titulo" %><%--
  Created by IntelliJ IDEA.
  User: gu12p
  Date: 15/10/2021
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Titulo</title>
</head>
<body>
<a href="index.jsp">Index</a>
<table>
    <th>ID</th>
    <th>Nome</th>
    <th>Autore(s)</th>
    <th>Diretor</th>
    <th>Ano</th>
    <th>Sinopse</th>
    <th>Categoria</th>
    <th>Classe</th>

    <tr>
        <form action="TituloServlet" method="post">
            <td>NEW</td>
            <td><input type="text" name="nome" value=""></td>
            <td><select name="ators" multiple>
                <%
                    EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
                    EntityManager manager = factory.createEntityManager();
                    CriteriaBuilder builder = manager.getCriteriaBuilder();
                    CriteriaQuery<Ator> query = builder.createQuery(Ator.class);
                    Root<Ator> atorRoot = query.from(Ator.class);
                    query.select(atorRoot);
                    TypedQuery<Ator> atorTypedQuery = manager.createQuery(query);
                    List<Ator> ators = atorTypedQuery.getResultList();

                    for (Ator ator : ators) {
                %>
                <option value="<%=ator.getId()%>"><%=ator.getName()%>
                </option>
                <%
                    }
                %>
            </select></td>
            <td><select name="diretor">
                <%
                    CriteriaQuery<Diretor> diretorCriteriaQuery = builder.createQuery(Diretor.class);
                    Root<Diretor> diretorRoot = diretorCriteriaQuery.from(Diretor.class);
                    diretorCriteriaQuery.select(diretorRoot);
                    TypedQuery<Diretor> diretorTypedQuery = manager.createQuery(diretorCriteriaQuery);
                    List<Diretor> diretorList = diretorTypedQuery.getResultList();

                    for (Diretor diretor : diretorList) {
                %>
                <option value="<%=diretor.getId()%>"><%=diretor.getNome()%>
                </option>
                <%
                    }
                %>
            </select></td>
            <td><input type="number" name="ano" value=""></td>
            <td><input type="text" name="sinopse" value=""></td>
            <td><input type="text" name="categoria" value=""></td>
            <td><select name="classe">
                <%
                    CriteriaQuery<Classe> classeCriteriaQuery = builder.createQuery(Classe.class);
                    Root<Classe> classeRoot = classeCriteriaQuery.from(Classe.class);
                    classeCriteriaQuery.select(classeRoot);
                    TypedQuery<Classe> classeTypedQuery = manager.createQuery(classeCriteriaQuery);
                    List<Classe> classeList = classeTypedQuery.getResultList();

                    for (Classe classe : classeList) {
                %>
                <option value="<%=classe.getId()%>"><%=classe.getNome()%>
                </option>
                <%
                    }
                %>
            </select></td>
            <td><input type="submit" name="action" value="save"></td>
        </form>
    </tr>
    <%
        CriteriaQuery<Titulo> tituloCriteriaQuery = builder.createQuery(Titulo.class);
        Root<Titulo> tituloRoot = tituloCriteriaQuery.from(Titulo.class);
        tituloCriteriaQuery.select(tituloRoot);
        TypedQuery<Titulo> tituloTypedQuery = manager.createQuery(tituloCriteriaQuery);
        List<Titulo> titulos = tituloTypedQuery.getResultList();
        for (Titulo titulo : titulos) {
    %>
    <tr>
        <form action="TituloServlet" method="post">
            <td><input type="number" name="id" value="<%=titulo.getId()%>" readonly></td>
            <td><input type="text" name="nome" value="<%=titulo.getNome()%>"></td>
            <td><select name="ators" multiple>
                <%
                    for (Ator ator : ators) {
                %>
                <option value="<%=ator.getId()%>" <%=titulo.containsAtorId(ator.getId()) ? "selected" : ""%>><%=ator.getName()%>
                </option>
                <%
                    }
                %>
            </select></td>
            <td><select name="diretor">
                <%
                    for (Diretor diretor : diretorList) {
                %>
                <option value="<%=diretor.getId()%>" <%=titulo.getDiretor().getId() == diretor.getId() ? "selected" : ""%>><%=diretor.getNome()%>
                </option>
                <%
                    }
                %>
            </select></td>
            <td><input type="number" name="ano" value="<%=titulo.getAno()%>"></td>
            <td><input type="text" name="sinopse" value="<%=titulo.getSinopse()%>"></td>
            <td><input type="text" name="categoria" value="<%=titulo.getCategoria()%>"></td>
            <td><select name="classe">
                <%
                    for (Classe classe : classeList) {
                %>
                <option value="<%=classe.getId()%>" <%=titulo.getClasse().getId() == classe.getId() ? "selected" : ""%>><%=classe.getNome()%>
                </option>
                <%
                    }
                %>
            </select></td>
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
