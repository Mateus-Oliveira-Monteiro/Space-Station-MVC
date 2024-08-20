package estacao.controller;

import estacao.dao.LoginDAO;
import estacao.model.Login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/lancamentos", "/editar", "/deletar"})
public class LoginController extends HttpServlet {

    private LoginDAO loginDAO;

    public LoginController() {
        this.loginDAO = new LoginDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();

        if ("/editar".equals(action)) {
            // Processar a edição de login
            int id = Integer.parseInt(req.getParameter("id"));
            Login login = loginDAO.read(id);
            req.setAttribute("login", login);
            RequestDispatcher dispatcher = req.getRequestDispatcher("editarEstacao.jsp");
            dispatcher.forward(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();

        if ("/lancamentos".equals(action)) {
            // Processar o cadastro de login
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");

            String nome = req.getParameter("nome");
            String senha = req.getParameter("senha");
            String mensagem;

            if (nome != null && !nome.isEmpty() && senha != null && !senha.isEmpty()) {
                // Cria um novo objeto Login sem ID
                Login login = new Login(null, nome, senha);

                // Tenta cadastrar no banco de dados
                boolean sucesso = loginDAO.create(login);

                if (sucesso) {
                    mensagem = "Login cadastrado com sucesso!";
                } else {
                    mensagem = "Erro ao cadastrar o login!";
                }
            } else {
                mensagem = "Preencha todos os campos!";
            }

            req.setAttribute("mensagem", mensagem);
            RequestDispatcher dispatcher = req.getRequestDispatcher("cadastrarEstacao.jsp");
            dispatcher.forward(req, resp);
        } else if ("/deletar".equals(action)) {
            // Processar a deleção de login
            int id = Integer.parseInt(req.getParameter("id"));
            loginDAO.delete(id);
            resp.sendRedirect("consultarEstacao.jsp");
        }
    }
}
