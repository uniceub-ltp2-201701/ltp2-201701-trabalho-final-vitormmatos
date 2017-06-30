<%@ page import="model.Genero" %>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="header.jsp" %>

    <title>Cinema</title>
</head>
<body>
    <%@ include file="navbar.jsp" %>

    <div class="info">
        <h2>Generos</h2>
    </div>

    <% ArrayList<Genero> generos = (ArrayList<Genero>) request.getAttribute("generos");%>
    <div class="well">
        <table class="table">
                <tbody>
                    <% for (Genero genero: generos) { %>
                        <tr><td><a href="${pageContext.request.contextPath}/genero?id=<%=genero.getIdGenero()%>"><%=genero.getNome()%></a></td></tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
