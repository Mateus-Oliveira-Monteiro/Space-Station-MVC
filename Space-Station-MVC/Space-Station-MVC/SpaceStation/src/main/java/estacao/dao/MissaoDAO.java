package estacao.dao;
import estacao.model.Astronauta;
import estacao.model.Missao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MissaoDAO {

    public void inserirMissao(Missao missao) {
        String sql = "INSERT INTO missao (nomeMissao, duracaoDias, motivo,Astronauta_idAstronauta,Foguete_idFoguete,Relatorio_idRelatorio,EmpresaParceria_idEmpresaParceria,estacao_idEstacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, missao.getNomeMissao());
            stmt.setInt(2, missao.getDuracaoDias());
            stmt.setString(3, missao.getMotivo());
            stmt.setInt(4, missao.getAstronautaIdAstronauta());
            stmt.setInt(5, missao.getFogueteIdFoguete());
            stmt.setInt(6, missao.getRelatorioIdRelatorio());
            stmt.setInt(7, missao.getEmpresaParceriaIdEmpresaParceria());
            stmt.setInt(8, missao.getEstacaoIdEstacao());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Missao> getALLMissoes() {
        List<Missao> missoes = new ArrayList<>();
        String sql = "SELECT * FROM missao";

        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Missao missao = new Missao();
                missao.setIdMissao(rs.getInt("idMissao"));
                missao.setNomeMissao(rs.getString("nomeMissao"));
                missao.setDuracaoDias(rs.getInt("duracaoDias"));
                missao.setMotivo(rs.getString("motivo"));
                missoes.add(missao);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return missoes;
    }
}
