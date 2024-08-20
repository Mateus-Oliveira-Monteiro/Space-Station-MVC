package estacao.controller;
import estacao.dao.EmpresaParceiraDAO;
import estacao.model.EmpresaParceria;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/EmpresaParceira")
public class EmpresaParceiraController extends HttpServlet {

    private EmpresaParceiraDAO empresaParceiraDAO;

    @Override
    public void init() {
        empresaParceiraDAO = new EmpresaParceiraDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<EmpresaParceria> empresas = empresaParceiraDAO.getALLEmpresas();
        request.setAttribute("empresas", empresas);

        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarEstacao.jsp");
        dispatcher.forward(request, response);
    }
}
