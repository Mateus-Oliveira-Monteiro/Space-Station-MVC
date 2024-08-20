<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="estacao.model.*" %>
<%@ page import="estacao.dao.*" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Missão Overview</title>
    <link rel="stylesheet" href="css/style.css">
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
<%
    CombustivelDAO combustivelDAO = new CombustivelDAO();
    List<Combustivel> combustiveis = combustivelDAO.getAllCombustiveis();
%>
<%
    OxigenioDAO oxigenioDAO = new OxigenioDAO();
    List<Oxigenio> oxigenios = oxigenioDAO.getAllOxigenios();
%>
<%
    EmpresaParceiraDAO empresaParceiraDAO = new EmpresaParceiraDAO();
    List<EmpresaParceria> empresas = empresaParceiraDAO.getALLEmpresas();
%>
<%
    EspecialidadeDAO especialidadeDao = new EspecialidadeDAO();
    List<Especialidade> especialidades = especialidadeDao.getALLEspecialidades();
%>
<form class="form-astronauta" action="${pageContext.request.contextPath}/MissaoController" method="post">
<div class="container">
    <div class="left-form">
            <div class="input-group">
                <div class="line-main">
                    <label> Astronauta</label>
                </div>
                <div class="line-inset">
                    <span>Nome:</span>
                    <input type="text"  name="nome_astronauta" id="nome_astronauta" placeholder="Ex: Neil Armstrong">
                </div>
                <div class="line-inset">
                    <span>País:</span>
                    <input type="text"  name="pais_astronauta" id="pais_astronauta" placeholder="Ex: EUA">
                </div>


                <div class="line-select">
                    <span>Especialidade</span>
                    <select id="especialidades" name="especialidades">
                        <option value="" disabled selected>Selecionar Especialidade</option>
                        <% for(Especialidade especialidade : especialidades) { %>
                        <option value="<%= especialidade.getIdEspecialidade() %>"><%= especialidade.getNome() %></option>
                        <% } %>
                    </select>
                </div>
            </div>
            <div class="input-group">
                <div class="line-main">
                    <label>Relatorio</label>
                </div>
                <div class="line-inset">
                    <span>Texto:</span>
                    <input type="text" name="relatorio_texto" id="relatorio_texto" placeholder="Ex: Pesquisa de solo">
                </div>
            </div>
            <div class="input-group">
                <div class="line-main">
                    <label>Empresa Parceira</label>
                </div>
                <div class="line-select">
                    <span>Nome</span>
                    <select id="empresas" name="empresas">
                        <option value="" disabled selected>Selecionar Empresa</option>
                        <% for(EmpresaParceria empresa : empresas) { %>
                        <option value="<%= empresa.getIdEmpresaParceria() %>"><%= empresa.getNomeEmpresa() %></option>
                        <% } %>
                    </select>
                </div>
            </div>
    </div>

    <div class="rocket">
        <img src="img/SpaceX 3D Model Render.png" alt="Rocket Image">
        <p>Cabin Mics: <span class="recording">RECORDING</span></p>
    </div>

    <div class="right-form">
            <div class="input-group">
                <div class="line-main">
                    <label>Estação</label>
                </div>
                <div class="line-inset">
                    <span>Nome:</span>
                    <input type="text" name="nome_estacao" id="nome_estacao" placeholder="Ex: Estação Internacional">
                </div>
                <div class="line-inset">
                    <span>Temperatura:</span>
                    <input type="text" name="temperatura" id="temperatura" placeholder="Ex: 27°C">
                </div>

                <div class="line-select">
                    <span>Oxigênio</span>
                    <select id="oxigenio_id" name="oxigenio_id">
                        <option value="" disabled selected>Selecionar Quantidade</option>
                        <% for(Oxigenio oxigenio : oxigenios) { %>
                        <option value="<%= oxigenio.getIdOxigenio() %>"><%= oxigenio.getQuantidadeAbastecida() %></option>
                        <% } %>
                    </select>
                </div>
            </div>
            <div class="input-group">
                <div class="line-main">
                    <label for="nome_foguete">Foguete</label><!--<button type="button">ADD</button>-->
                </div>
                <div class="line-inset">
                    <span>Nome:</span>
                    <input type="text" id="nome_foguete" name="nome_foguete" placeholder="Ex: Apollo 11">
                </div>
                <div class="line-inset">
                    <span>Lançamento:</span>
                    <label for="local_lancamento"></label><input type="text" id="local_lancamento" name="local_lancamento" placeholder="Ex: Brasil">
                </div>

                <div class="line-select">
                    <span>Combustivel</span>
                    <select id="combustivel_id" name="combustivel_id">
                        <option value="" disabled selected>Selecionar Marca</option>
                        <% for(Combustivel combustivel : combustiveis) { %>
                        <option value="<%= combustivel.getIdCombustivel() %>"><%= combustivel.getMarca() %></option>
                        <% } %>
                    </select>
                </div>
            </div>
        <div class="input-group">
            <div class="line-main">
                <label>Missão</label>
            </div>
            <div class="line-inset">
                <span>Nome:</span>
                <input type="text" name="nome_missao" id="nome_missao" placeholder="Ex: Estação Internacional">
            </div>
            <div class="line-inset">
                <span>Duração:</span>
                <input type="text" name="duracao" id="duracao" placeholder="Ex: 4 Dias">
            </div>
            <div class="line-inset">
                <span>motivo:</span>
                <input type="text" name="motivo" id="motivo" placeholder="Ex: Pesquisas gerais">
            </div>
        </div>
    </div>
</div>

<div class="buttons">
    <button id="start" type="submit">INICIAR</button>
    <button id="reset" type="reset">RESETAR</button>
</div>
</form>

<script src="script.js"></script>
</body>
</html>