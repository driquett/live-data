package dao;

import config.DatabaseConnection;
import model.Credential;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CredentialDAO {

    public void insertCredential(Credential credential) {
        String sql = "INSERT INTO credencial(codigo, id_empleado) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, credential.getCode());
            stmt.setInt(2, credential.getEmployeeId());
            stmt.executeUpdate();

            System.out.println("Credencial creada");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Credential> getCredentials() {
        List<Credential> list = new ArrayList<>();
        String sql = "SELECT * FROM credencial";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Credential(
                        rs.getInt("id_credencial"),
                        rs.getString("codigo"),
                        rs.getInt("id_empleado")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
        
    }

    public void updateCredential(Credential credential) {

    String sql =
            "UPDATE credencial SET codigo=?, id_empleado=? WHERE id_credencial=?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, credential.getCode());
        stmt.setInt(2, credential.getEmployeeId());
        stmt.setInt(3, credential.getId());

        stmt.executeUpdate();

        System.out.println("Credencial actualizada");

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}