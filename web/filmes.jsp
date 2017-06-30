<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Filme" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="model.Genero" %>
<%@ page import="model.GeneroFilme" %>

<html>
  <head>

  <%@ include file="header.jsp" %>

  <title>Cinema</title>
</head>
<body>

  <%@ include file="navbar.jsp" %>

  <% ArrayList<Filme> filmes = (ArrayList<Filme>) request.getAttribute("filmes");%>
  <% ArrayList<Genero> generos = (ArrayList<Genero>) request.getAttribute("generos");%>
  <% ArrayList<GeneroFilme> generosFilmes = (ArrayList<GeneroFilme>) request.getAttribute("generosFilmes");%>

  <div class="info">
        <h2>Filmes</h2>
  </div>

  <div class="well">
  <table class="table">
      <tbody>
        <% for (int i = 0; i<filmes.size(); i++) { %>
            <tr>
              <td>
                  <span class="glyphicon glyphicon-film"></span>
                  <a href="${pageContext.request.contextPath}/filme?id=<%=filmes.get(i).getIdFilme()%>">
                      <%=filmes.get(i).getNome()%></a>
              </td>
              <td>
                  Data de Nascimento:<br><%= filmes.get(i).getDataLanc().get(Calendar.DAY_OF_MONTH)%>/
                  <%= filmes.get(i).getDataLanc().get(Calendar.MONTH) + 1%>/
                  <%= filmes.get(i).getDataLanc().get(Calendar.YEAR)%>
              </td>
              <td>
                  Faixa Etária: <%= filmes.get(i).getFaixaEtaria() %>
              </td>
                <td>
                  <%for (GeneroFilme generoFilme: generosFilmes){%>
                    <%if(generoFilme.getIdFilme() == filmes.get(i).getIdFilme()){%>
                        <a href="${pageContext.request.contextPath}/genero?id=<%=generos.get(generoFilme.getIdGenero()-1).getIdGenero()%>"><%=generos.get(generoFilme.getIdGenero()-1).getNome()%></a>
                    <%}%>
                  <%}%>
                </td>
            </tr>
          <% } %>
      </tbody>
  </table>
  </div>
  </body>
</html>