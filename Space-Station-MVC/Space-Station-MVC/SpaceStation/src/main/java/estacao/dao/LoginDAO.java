package estacao.dao;

import estacao.model.Login;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {

    private ConnectionFactory connectionFactory;

    public LoginDAO() {
        this.connectionFactory = ConnectionFactory.getInstance();
    }

    public boolean create(Login login) {
        String sql = "INSERT INTO login (nome, senha) VALUES (?, ?)";
        try (PreparedStatement stmt = connectionFactory.getPreparedStatement(sql)) {
            stmt.setString(1, login.getNome());
            stmt.setString(2, login.getSenha());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Login read(int id) {
        String sql = "SELECT * FROM login WHERE idLogin = ?";
        Login login = null;
        try (PreparedStatement stmt = connectionFactory.getPreparedStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    login = new Login(
                            rs.getInt("idLogin"),
                            rs.getString("nome"),
                            rs.getString("senha")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return login;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM login WHERE idLogin = ?";
        try (PreparedStatement stmt = connectionFactory.getPreparedStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Login> listAll() {
        String sql = "SELECT * FROM login";
        List<Login> logins = new ArrayList<>();
        try (PreparedStatement stmt = connectionFactory.getPreparedStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Login login = new Login(
                        rs.getInt("idLogin"),
                        rs.getString("nome"),
                        rs.getString("senha")
                );
                logins.add(login);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logins;
    }
}
