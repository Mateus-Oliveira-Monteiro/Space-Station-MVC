package estacao.controller;
import estacao.dao.AstronautaDAO;
import estacao.dao.RelatorioDAO;
import estacao.model.Astronauta;
import estacao.model.Relatorio;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RelatorioController")
public class RelatorioController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Relatorio relatorio = new Relatorio();
        relatorio.setDescricao(request.getParameter("relatorio_texto"));
        RelatorioDAO relatorioDAO = new RelatorioDAO();
        relatorioDAO.inserirRelatorio(relatorio);
        response.sendRedirect("success.jsp");
    }
}
