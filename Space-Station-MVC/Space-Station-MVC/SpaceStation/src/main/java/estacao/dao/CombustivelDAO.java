package estacao.dao;

import estacao.model.Combustivel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CombustivelDAO {

    public List<Combustivel> getAllCombustiveis() {
        List<Combustivel> combustiveis = new ArrayList<>();
        String sql = "SELECT idCombustivel, marca FROM combustivel";

        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Combustivel combustivel = new Combustivel();
                combustivel.setIdCombustivel(rs.getInt("idCombustivel"));
                combustivel.setMarca(rs.getString("marca"));
                combustiveis.add(combustivel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return combustiveis;
    }
}
