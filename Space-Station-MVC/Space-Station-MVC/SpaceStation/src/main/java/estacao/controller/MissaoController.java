package estacao.controller;

import estacao.dao.*;
import estacao.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/MissaoController")
public class MissaoController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Foguete foguete = new Foguete();
        foguete.setNome(request.getParameter("nome_foguete"));
        foguete.setLocalLancamento(request.getParameter("local_lancamento"));
        foguete.setCombustivelId(Integer.parseInt(request.getParameter("combustivel_id")));
        FogueteDAO fogueteDAO = new FogueteDAO();
        int idFoguete = fogueteDAO.inserirFoguete(foguete);

        Estacao estacao = new Estacao();
        estacao.setNome(request.getParameter("nome_estacao"));
        estacao.setTemperatura(Float.parseFloat(request.getParameter("temperatura")));
        estacao.setOxigenioIdOxigenio(Integer.parseInt(request.getParameter("oxigenio_id")));
        EstacaoDAO estacaoDAO = new EstacaoDAO();
        int idEstacao = estacaoDAO.inserirEstacao(estacao);

        Astronauta astronauta = new Astronauta();
        astronauta.setNomeAstro(request.getParameter("nome_astronauta"));
        astronauta.setPais(request.getParameter("pais_astronauta"));
        astronauta.setEspecialidadeIdEspecialidade(Integer.parseInt(request.getParameter("especialidades")));
        AstronautaDAO astronautaDAO = new AstronautaDAO();
        int idAstro = astronautaDAO.inserirAstronauta(astronauta);

        Relatorio relatorio = new Relatorio();
        relatorio.setDescricao(request.getParameter("relatorio_texto"));
        RelatorioDAO relatorioDAO = new RelatorioDAO();
        int idRelatorio = relatorioDAO.inserirRelatorio(relatorio);


        Missao missao = new Missao();
        missao.setNomeMissao(request.getParameter("nome_missao"));
        missao.setDuracaoDias(Integer.parseInt(request.getParameter("duracao")));
        missao.setMotivo(request.getParameter("motivo"));
        missao.setAstronautaIdAstronauta(idAstro);
        missao.setEmpresaParceriaIdEmpresaParceria(Integer.parseInt(request.getParameter("empresas")));
        missao.setEstacaoIdEstacao(idEstacao);
        missao.setFogueteIdFoguete(idFoguete);
        missao.setRelatorioIdRelatorio(idRelatorio);
        MissaoDAO missaoDAO = new MissaoDAO();
        missaoDAO.inserirMissao(missao);


        response.sendRedirect("success.jsp");
    }
}
