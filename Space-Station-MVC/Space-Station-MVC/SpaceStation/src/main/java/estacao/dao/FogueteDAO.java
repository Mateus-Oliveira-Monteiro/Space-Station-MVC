package estacao.dao;

import estacao.model.Foguete;
import estacao.model.Missao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FogueteDAO {

    public int inserirFoguete(Foguete foguete) {
        String sql = "INSERT INTO foguete (nome, localLancamento, Combustivel_idCombustivel) VALUES (?, ?, ?)";
        int idGerado = 0;

        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, foguete.getNome());
            stmt.setString(2, foguete.getLocalLancamento());
            stmt.setInt(3, foguete.getCombustivelId());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        idGerado = rs.getInt(1);
                        foguete.setIdFoguete(idGerado); // Atribui o ID ao objeto Foguete
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idGerado;
    }

    public List<Foguete> getALLFoguetes() {
        List<Foguete> foguetes = new ArrayList<>();
        String sql = "SELECT * FROM foguete";

        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Foguete foguete = new Foguete();
                foguete.setIdFoguete(rs.getInt("idFoguete"));
                foguete.setNome(rs.getString("nome"));
                foguete.setCombustivelId(rs.getInt("Combustivel_idCombustivel"));
                foguete.setLocalLancamento(rs.getString("localLancamento"));
                foguetes.add(foguete);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foguetes;
    }
}
