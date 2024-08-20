package estacao.dao;

import estacao.model.Estacao;
import estacao.model.Foguete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstacaoDAO {

    public int inserirEstacao(Estacao estacao) {
        String sql = "INSERT INTO estacao (nome, temperatura, Oxigenio_idOxigenio) VALUES (?, ?, ?)";
        int idGerado = 0;

        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, estacao.getNome());
            stmt.setFloat(2, estacao.getTemperatura());
            stmt.setInt(3, estacao.getOxigenioIdOxigenio());
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        idGerado = rs.getInt(1);
                        estacao.setIdEstacao(idGerado); // Atribui o ID ao objeto Estacao
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idGerado;
    }
    public List<Estacao> getALLEstacoes() {
        List<Estacao> estacoes = new ArrayList<>();
        String sql = "SELECT * FROM estacao";

        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Estacao estacao = new Estacao();
                estacao.setIdEstacao(rs.getInt("idEstacao"));
                estacao.setNome(rs.getString("nome"));
                estacao.setTemperatura(rs.getFloat("temperatura"));
                estacao.setOxigenioIdOxigenio(rs.getInt("Oxigenio_idOxigenio"));
                estacoes.add(estacao);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return estacoes;
    }
}
