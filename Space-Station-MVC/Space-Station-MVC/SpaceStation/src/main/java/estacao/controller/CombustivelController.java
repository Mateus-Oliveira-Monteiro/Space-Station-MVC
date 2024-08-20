package estacao.controller;

import estacao.dao.CombustivelDAO;
import estacao.model.Combustivel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/combustivel")
public class CombustivelController extends HttpServlet {

    private CombustivelDAO combustivelDAO;

    @Override
    public void init() {
        combustivelDAO = new CombustivelDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtendo todos os combustíveis
        List<Combustivel> combustiveis = combustivelDAO.getAllCombustiveis();

        // Atribuindo a lista de combustíveis ao request
        request.setAttribute("combustiveis", combustiveis);

        // Redirecionando para o JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarEstacao.jsp");
        dispatcher.forward(request, response);
    }
}
