<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="estacao.dao.*" %>
<%@ page import="estacao.model.*" %>
<html>
<head>
    <title>Consulta Estação</title>
</head>
<body>
<nav>
    <ul>
        <li><span>NASA</span></li>
        <li><a href="cadastrarEstacao.jsp">Cadastrar Estação</a></li>
        <li><a href="consultarEstacao.jsp">Consultar Estação</a></li>
        <li><a href="login.jsp">Login</a></li>
    </ul>
</nav>
<main>
    <h1>Consultar Logins</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Senha</th>
            <th>Ações</th>
        </tr>
        <%
            LoginDAO loginDAO = new LoginDAO();
            List<Login> logins = loginDAO.listAll();

            for (Login login : logins) {
        %>
        <tr>
            <td><%= login.getIdLogin() %></td>
            <td><%= login.getNome() %></td>
            <td><%= login.getSenha() %></td>
            <td>
                <form action="${pageContext.request.contextPath}/deletar" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="<%= login.getIdLogin() %>">
                    <input type="submit" value="Deletar" onclick="return confirm('Tem certeza que deseja deletar este login?');">
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <h1>Consultar Astronautas</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Pais</th>
            <th>Especialidade</th>
        </tr>
        <%
            AstronautaDAO astronautaDAO = new AstronautaDAO();
            List<Astronauta> astronautas = astronautaDAO.getALLAstronautas();

            for (Astronauta astronauta : astronautas) {
        %>
        <tr>
            <td><%= astronauta.getIdAstronauta() %></td>
            <td><%= astronauta.getNomeAstro() %></td>
            <td><%= astronauta.getPais()%> </td>
            <td><%= astronauta.getEspecialidadeIdEspecialidade()%> </td>
        </tr>
        <%
            }
        %>
    </table>
    </table>
    <h1>Consultar Missoes</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Duração</th>
        </tr>
        <%
            MissaoDAO missaoDAO = new MissaoDAO();
            List<Missao> missoes = missaoDAO.getALLMissoes();

            for (Missao missao : missoes) {
        %>
        <tr>
            <td><%= missao.getIdMissao() %></td>
            <td><%= missao.getNomeMissao() %></td>
            <td><%= missao.getDuracaoDias()%> </td>
        </tr>
        <%
            }
        %>
    </table>
    <h1>Consultar Foguetes</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Combustivel</th>
            <th>Local Lançamentos</th>
        </tr>
        <%
            FogueteDAO fogueteDAO = new FogueteDAO();
            List<Foguete> foguetes = fogueteDAO.getALLFoguetes();

            for (Foguete foguete : foguetes) {
        %>
        <tr>
            <td><%= foguete.getIdFoguete() %></td>
            <td><%= foguete.getNome() %></td>
            <td><%= foguete.getCombustivelId()%> </td>
            <td><%= foguete.getLocalLancamento()%> </td>
        </tr>
        <%
            }
        %>
    </table>

    <h1>Consultar Estações</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Temperatura</th>
            <th>Oxigênio</th>
        </tr>
        <%
            EstacaoDAO estacaoDAO = new EstacaoDAO();
            List<Estacao> estacoes = estacaoDAO.getALLEstacoes();

            for (Estacao estacao : estacoes) {
        %>
        <tr>
            <td><%= estacao.getIdEstacao() %></td>
            <td><%= estacao.getNome() %></td>
            <td><%= estacao.getTemperatura()%> </td>
            <td><%= estacao.getOxigenioIdOxigenio()%> </td>
        </tr>
        <%
            }
        %>
    </table>
</main>
</body>
</html>
