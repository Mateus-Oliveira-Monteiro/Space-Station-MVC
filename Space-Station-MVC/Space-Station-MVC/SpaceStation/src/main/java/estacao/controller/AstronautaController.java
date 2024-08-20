package estacao.controller;
import estacao.dao.AstronautaDAO;
import estacao.dao.FogueteDAO;
import estacao.model.Astronauta;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AstronautaController")
public class AstronautaController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Astronauta astronauta = new Astronauta();
        astronauta.setNomeAstro(request.getParameter("nome_astronauta"));
        astronauta.setPais(request.getParameter("pais_astronauta"));
        astronauta.setEspecialidadeIdEspecialidade(Integer.parseInt(request.getParameter("especialidades")));

        AstronautaDAO astronautaDAO = new AstronautaDAO();
        astronautaDAO.inserirAstronauta(astronauta);

        response.sendRedirect("success.jsp");
    }
}
