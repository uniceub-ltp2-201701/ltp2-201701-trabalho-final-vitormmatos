<%--
  Created by IntelliJ IDEA.
  User: vitormatos
  Date: 26/06/17
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="model.Pessoa" %>
<%@ page import="model.Filme" %>


<html>
<head>

    <%@ include file="header.jsp" %>
    <title>Cinema</title>

</head>
<body>

    <%@include file="navbar.jsp"%>

    <% ArrayList<Filme> filmes = (ArrayList<Filme>) request.getAttribute("filmes");%>
    <% Pessoa pessoa = (Pessoa) request.getAttribute("pessoa");%>

    <div class="info">
        <h1><%=pessoa.getNome()%></h1>
    </div>

    <div class="well">
        <p><img style="float: left; margin-right: 10px" class="img-rounded" width="250" height="250" src="<%=pessoa.getFotoLink()%>">
            <%=pessoa.getDescricao()%>
            <br style="clear: both;">
        </p>
    </div>

    <div class="info">
        <h3>Filmes Estrelados:</h3>
    </div>

    <div class="well">
        <table class="table">
        <thead>
        <tr>
            <th>Nome</th>
            <th>Data de Lançamento</th>
            <th>Faixa Etária</th>
        </tr>
        </thead>

        <tbody>
        <% for (Filme filme : filmes) { %>
        <tr>
            <td>
                <span class="glyphicon glyphicon-film"></span>
                <a href="${pageContext.request.contextPath}/filme?id=<%=filme.getIdFilme()%>">
                    <%=filme.getNome()%></a>
            </td>
            <td>
                <%= filme.getDataLanc().get(Calendar.DAY_OF_MONTH)%>/
                <%= filme.getDataLanc().get(Calendar.MONTH) + 1%>/
                <%= filme.getDataLanc().get(Calendar.YEAR)%>
            </td>
            <td>
                <%= filme.getFaixaEtaria() %>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    </div>

</body>
</html>
