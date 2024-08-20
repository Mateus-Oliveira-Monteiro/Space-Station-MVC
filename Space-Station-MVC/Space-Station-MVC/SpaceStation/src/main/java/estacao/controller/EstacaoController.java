package estacao.controller;

import estacao.dao.EstacaoDAO;
import estacao.model.Estacao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EstacaoController")
public class EstacaoController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Estacao estacao = new Estacao();
        estacao.setNome(request.getParameter("nome_estacao"));
        estacao.setTemperatura(Float.parseFloat(request.getParameter("temperatura")));
        estacao.setOxigenioIdOxigenio(Integer.parseInt(request.getParameter("oxigenio_id")));

        EstacaoDAO estacaoDAO = new EstacaoDAO();
        estacaoDAO.inserirEstacao(estacao);

        response.sendRedirect("success.jsp"); // redireciona para uma página de sucesso
    }
}
