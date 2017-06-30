<%@ page import="model.Filme" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Genero" %>
<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="header.jsp" %>

    <title>Cinema</title>
</head>
<body>
    <%@ include file="navbar.jsp" %>

    <% Genero genero = (Genero) request.getAttribute("genero");%>
    <% ArrayList<Filme> filmes = (ArrayList<Filme>) request.getAttribute("filmes");%>

    <div class="info">
        <h2>Filmes de <%=genero.getNome()%></h2>
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
                <% for (int i = 0; i<filmes.size(); i++) { %>
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/filme?id=<%=filmes.get(i).getIdFilme()%>"><%=filmes.get(i).getNome()%></a>
                    </td>
                    <td>
                        <%= filmes.get(i).getDataLanc().get(Calendar.DAY_OF_MONTH)%>/
                        <%= filmes.get(i).getDataLanc().get(Calendar.MONTH) + 1%>/
                        <%= filmes.get(i).getDataLanc().get(Calendar.YEAR)%>
                    </td>
                    <td>
                        <%= filmes.get(i).getFaixaEtaria() %>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>

</body>
</html>
