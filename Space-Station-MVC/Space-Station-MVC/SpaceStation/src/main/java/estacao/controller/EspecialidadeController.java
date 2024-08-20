package estacao.controller;
import estacao.dao.EspecialidadeDAO;
import estacao.model.Especialidade;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Especialidade")
public class EspecialidadeController extends HttpServlet {

    private EspecialidadeDAO especialidadeDao;

    @Override
    public void init() {
        especialidadeDao = new EspecialidadeDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Especialidade> especialidades = especialidadeDao.getALLEspecialidades();
        request.setAttribute("especialidades", especialidades);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarEstacao.jsp");
        dispatcher.forward(request, response);
    }
}
