package estacao.dao;

import estacao.model.Combustivel;
import estacao.model.EmpresaParceria;
import estacao.model.Especialidade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadeDAO {

    public List<Especialidade> getALLEspecialidades() {
        List<Especialidade> especialidades = new ArrayList<>();
        String sql = "SELECT idEspecialidade, nome FROM especialidade";

        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Especialidade especialidade = new Especialidade();
                especialidade.setIdEspecialidade(rs.getInt("idEspecialidade"));
                especialidade.setNome(rs.getString("nome"));
                especialidades.add(especialidade);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return especialidades;
    }
}
