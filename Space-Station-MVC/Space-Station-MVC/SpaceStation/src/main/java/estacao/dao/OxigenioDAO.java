package estacao.dao;

import estacao.model.Combustivel;
import estacao.model.Oxigenio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OxigenioDAO {

    public List<Oxigenio> getAllOxigenios() {
        List<Oxigenio> oxigenios = new ArrayList<>();
        String sql = "SELECT idOxigenio, quantidadeAbastecida FROM oxigenio";

        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Oxigenio oxigenio = new Oxigenio();
                oxigenio.setIdOxigenio(rs.getInt("idOxigenio"));
                oxigenio.setQuantidadeAbastecida(rs.getFloat("quantidadeAbastecida"));
                oxigenios.add(oxigenio);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return oxigenios;
    }
}
