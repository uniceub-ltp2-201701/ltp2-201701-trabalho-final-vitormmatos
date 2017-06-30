<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="model.Personagem" %>
<%@ page import="model.Pessoa" %>
<%@ page import="model.Filme" %>
<%@ page import="model.Genero" %>

<html>
<head>
    <%@ include file="header.jsp" %>

    <title>Cinema</title>
</head>
<body>

    <%@include file="navbar.jsp"%>

    <% ArrayList<Personagem> personagens = (ArrayList<Personagem>) request.getAttribute("personagens");%>
    <% ArrayList<Pessoa> roteiristas = (ArrayList<Pessoa>) request.getAttribute("roteiristas");%>
    <% ArrayList<Pessoa> diretores = (ArrayList<Pessoa>) request.getAttribute("diretores");%>
    <% ArrayList<Pessoa> pessoas = (ArrayList<Pessoa>) request.getAttribute("atores");%>
    <% ArrayList<Genero> generos = (ArrayList<Genero>) request.getAttribute("generos"); %>
    <% Filme filme = (Filme) request.getAttribute("filme");%>

    <div class="info">
        <h2><%=filme.getNome()%> (<%=filme.getDataLanc().get(Calendar.YEAR)%>)</h2><br>
    </div>

    <div class="well">
        <p><img style="float: left; margin-right: 10px; margin-bottom: 10px" class="img-rounded" width="150" height="210" src="<%=filme.getCartazLink()%>">
            <%=filme.getSinopse()%>
            <div style="margin-top: 10px">
                <%for (Genero genero: generos){%>
                    <a href="${pageContext.request.contextPath}/genero?id=<%=genero.getIdGenero()%>" style="margin-right: 4px"><%=genero.getNome()%></a>
                <%}%>
                <br>Faixa Etária: <%=filme.getFaixaEtaria()%>
                <br>Lançado em:
                <%= filme.getDataLanc().get(Calendar.DAY_OF_MONTH)%>/
                <%= filme.getDataLanc().get(Calendar.MONTH) + 1%>/
                <%= filme.getDataLanc().get(Calendar.YEAR)%>
            </div>
        <br style="clear: both;">
        </p>
    </div>

    <div class="info">
        <h3>Trailer</h3>
    </div>

    <div class="trailer">
        <iframe width="504" height="284" src="<%=filme.getTrailerLink()%>" frameborder="0" allowfullscreen></iframe>
    </div>

    <div class="well">
        <table class="table" style="table-layout: ">
            <thead>
                <tr>
                    <th>Ator</th>
                    <th>Personagem</th>
                    <th>Data de Nascimento</th>
                    <th>Sexo</th>
                </tr>
            </thead>
            <tbody>
                <% for (int i=0; i< personagens.size(); i++) { %>
                    <tr>
                        <td>
                            <img src="<%=pessoas.get(i).getFotoLink()%>" alt="<%=pessoas.get(i).getNome()%>" style="width:50px;height:50px;">
                            <a href="${pageContext.request.contextPath}pessoa?id=<%=pessoas.get(i).getIdPessoa()%>"><%=pessoas.get(i).getNome()%></a>
                        </td>
                        <td>
                            <%= personagens.get(i).getNomePersonagem()%>
                        </td>
                        <td>
                            <%= pessoas.get(i).getDataNascimento().get(Calendar.DAY_OF_MONTH)%>/
                            <%= pessoas.get(i).getDataNascimento().get(Calendar.MONTH) + 1%>/
                            <%= pessoas.get(i).getDataNascimento().get(Calendar.YEAR)%>
                        </td>
                        <td>
                            <% if (pessoas.get(i).getSexo() == 1){%>
                                <img src="fonts/glyphicons-751-gender-male.png">
                            <%}else{%>
                                <img src="fonts/glyphicons-752-gender-female.png">
                            <%}%>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>

    <div class="well">
        <table class="table">
        <thead>
        <tr>
            <th>Diretor</th>
            <th>Data de Nascimento</th>
            <th>Sexo</th>
        </tr>
        </thead>
        <tbody>
            <% for (Pessoa diretor: diretores) { %>
                <tr>
                    <td>
                        <img src="<%=diretor.getFotoLink()%>" alt="<%=diretor.getNome()%>" style="width:50px;height:50px;">
                        <a href="${pageContext.request.contextPath}pessoa?id=<%=diretor.getIdPessoa()%>"><%=diretor.getNome()%></a>
                    </td>
                    <td>
                        <%= diretor.getDataNascimento().get(Calendar.DAY_OF_MONTH)%>/
                        <%= diretor.getDataNascimento().get(Calendar.MONTH) + 1%>/
                        <%= diretor.getDataNascimento().get(Calendar.YEAR)%>
                    </td>
                    <td>
                        <% if (diretor.getSexo() == 1){%>
                            <img src="fonts/glyphicons-751-gender-male.png">
                        <%}else{%>
                            <img src="fonts/glyphicons-752-gender-female.png">
                        <%}%>
                    </td>
                </tr>
            <% } %>
        </tbody>
    </table>
    </div>

    <div class="well">
        <table class="table">
            <thead>
            <tr>
                <th>Roteirista</th>
                <th>Data de Nascimento</th>
                <th>Sexo</th>
            </tr>
            </thead>
            <tbody>
            <% for (Pessoa roteirista: roteiristas) { %>
            <tr>
                <td>
                    <img src="<%=roteirista.getFotoLink()%>" alt="<%=roteirista.getNome()%>" style="width:50px;height:50px;">
                    <a href="${pageContext.request.contextPath}pessoa?id=<%=roteirista.getIdPessoa()%>"><%=roteirista.getNome()%></a>
                </td>
                <td>
                    <%= roteirista.getDataNascimento().get(Calendar.DAY_OF_MONTH)%>/
                    <%= roteirista.getDataNascimento().get(Calendar.MONTH) + 1%>/
                    <%= roteirista.getDataNascimento().get(Calendar.YEAR)%>
                </td>
                <td>
                    <% if (roteirista.getSexo() == 1){%>
                        <img src="fonts/glyphicons-751-gender-male.png">
                    <%}else{%>
                        <img src="fonts/glyphicons-752-gender-female.png">
                    <%}%>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>

</body>
</html>
