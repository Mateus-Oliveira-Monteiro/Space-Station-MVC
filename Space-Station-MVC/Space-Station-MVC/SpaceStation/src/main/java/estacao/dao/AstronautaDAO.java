package estacao.dao;

import estacao.model.Astronauta;
import estacao.model.Login;
import estacao.model.Oxigenio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AstronautaDAO {
    public int inserirAstronauta(Astronauta astronauta) {
        String sql = "INSERT INTO astronauta (nomeAstro, pais, Especialidade_idEspecialidade) VALUES (?, ?, ?)";
        int idGerado = 0;

        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, astronauta.getNomeAstro());
            stmt.setString(2, astronauta.getPais());
            stmt.setInt(3, astronauta.getEspecialidadeIdEspecialidade());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        idGerado = rs.getInt(1);
                        astronauta.setIdAstronauta(idGerado); // Atribui o ID ao objeto Astronauta
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idGerado;
    }
    public List<Astronauta> getALLAstronautas() {
        List<Astronauta> astronautas = new ArrayList<>();
        String sql = "SELECT * FROM astronauta";

        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Astronauta astronauta = new Astronauta();
                astronauta.setIdAstronauta(rs.getInt("idAstronauta"));
                astronauta.setNomeAstro(rs.getString("nomeAstro"));
                astronauta.setPais(rs.getString("pais"));
                astronauta.setEspecialidadeIdEspecialidade(rs.getInt("Especialidade_idEspecialidade"));
                astronautas.add(astronauta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return astronautas;
    }

}
