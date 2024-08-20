package estacao.dao;

import estacao.model.Combustivel;
import estacao.model.EmpresaParceria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpresaParceiraDAO {

    public List<EmpresaParceria> getALLEmpresas() {
        List<EmpresaParceria> empresas = new ArrayList<>();
        String sql = "SELECT idEmpresaParceria, nomeEmpresa FROM empresaparceria";

        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                EmpresaParceria empresa = new EmpresaParceria();
                empresa.setIdEmpresaParceria(rs.getInt("idEmpresaParceria"));
                empresa.setNomeEmpresa(rs.getString("nomeEmpresa"));
                empresas.add(empresa);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empresas;
    }
}
