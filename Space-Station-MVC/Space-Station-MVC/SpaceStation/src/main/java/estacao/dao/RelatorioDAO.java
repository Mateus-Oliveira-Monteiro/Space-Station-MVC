package estacao.dao;

import estacao.model.Relatorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RelatorioDAO {

    public int inserirRelatorio(Relatorio relatorio) {
        String sql = "INSERT INTO relatorio (descricao) VALUES (?)";
        int idGerado = 0;

        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, relatorio.getDescricao());
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        idGerado = rs.getInt(1);
                        relatorio.setIdRelatorio(idGerado); // Atribui o ID ao objeto Relatorio
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idGerado;
    }
}
