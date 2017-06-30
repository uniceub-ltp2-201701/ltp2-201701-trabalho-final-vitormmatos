<%@ page import="model.Pessoa" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="header.jsp" %>

    <title>Cinema</title>
</head>
<body>
    <%@ include file="navbar.jsp" %>

    <% ArrayList<Pessoa> pessoas = (ArrayList<Pessoa>) request.getAttribute("pessoas");%>
    <% String tipoPessoa = (String) request.getAttribute("tipoPessoa");%>

    <div class="info">
        <h2><%=tipoPessoa%></h2>
    </div>

    <div class="well" style="margin-top: 40px">
        <table class="table">
                <tbody>
                    <% for (Pessoa pessoa: pessoas) { %>
                    <tr>
                        <td>
                            <img src="<%=pessoa.getFotoLink()%>" alt="<%=pessoa.getNome()%>" style="width:50px;height:50px;">
                            <a href="${pageContext.request.contextPath}pessoa?id=<%=pessoa.getIdPessoa()%>"><%=pessoa.getNome()%></a>
                        </td>
                        <td>
                            <%= pessoa.getDataNascimento().get(Calendar.DAY_OF_MONTH)%>/
                            <%= pessoa.getDataNascimento().get(Calendar.MONTH) + 1%>/
                            <%= pessoa.getDataNascimento().get(Calendar.YEAR)%>
                        </td>
                        <td>
                            <% if (pessoa.getSexo() == 1){%>
                                <img src="fonts/glyphicons-751-gender-male.png">
                            <%}else{%>
                                <img src="fonts/glyphicons-752-gender-female.png">
                            <%}%>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
