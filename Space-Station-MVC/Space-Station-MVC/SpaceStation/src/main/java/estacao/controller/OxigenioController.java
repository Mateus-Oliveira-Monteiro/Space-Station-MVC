package estacao.controller;

import estacao.dao.CombustivelDAO;
import estacao.dao.OxigenioDAO;
import estacao.model.Combustivel;
import estacao.model.Oxigenio;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/oxigenio")
public class OxigenioController extends HttpServlet {

    private OxigenioDAO oxigenioDAO;

    @Override
    public void init() {
        oxigenioDAO = new OxigenioDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Oxigenio> oxigenios = oxigenioDAO.getAllOxigenios();

        request.setAttribute("oxigenios", oxigenios);

        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarEstacao.jsp");
        dispatcher.forward(request, response);
    }
}
