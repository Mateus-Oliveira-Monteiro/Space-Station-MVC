package estacao.controller;

import estacao.dao.FogueteDAO;
import estacao.model.Foguete;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FogueteController")
public class FogueteController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Foguete foguete = new Foguete();
        foguete.setNome(request.getParameter("nome"));
        foguete.setLocalLancamento(request.getParameter("local"));
        foguete.setCombustivelId(Integer.parseInt(request.getParameter("combustivel_id")));

        FogueteDAO fogueteDAO = new FogueteDAO();
        fogueteDAO.inserirFoguete(foguete);

        response.sendRedirect("success.jsp"); // redireciona para uma página de sucesso
    }
}
