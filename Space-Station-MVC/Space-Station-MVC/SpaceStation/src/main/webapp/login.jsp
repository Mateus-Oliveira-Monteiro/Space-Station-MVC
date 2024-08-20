<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro Estação</title>
    <link rel="stylesheet" href="css/styleLogin.css">
</head>
<body>
<nav class="navigation-menu">
    <ul class="container">
        <li><span>NASA</span></li>
        <li><a href="cadastrarEstacao.jsp">Cadastrar Estação</a></li>
        <li><a href="consultarEstacao.jsp">Consultar Estação</a></li>
        <li><a href="login.jsp">Login</a></li>
    </ul>
</nav>
<main>

    <div class="login-container">
        <div class="form-section">
            <h1>SpaceX's Dragon</h1>
            <form action="${pageContext.request.contextPath}/lancamentos" method="post" class="Login">
                <div class="input-group">
                    <label for="nome">Username:</label>
                    <input type="text" id="nome" name="nome">
                </div>
                <div class="input-group">
                    <label for="senha">Password:</label>
                    <input type="password" id="senha" name="senha">
                </div>
                <button id="botaoEnviar" type="submit" name="salvar">LOGIN</button>
                <div class="message">
                </div>
            </form>
        </div>
        <div class="image-section">
            <img src="img/spaceX.png" alt="SpaceX Rocket">
        </div>
    </div>
</main>
</body>
</html>


