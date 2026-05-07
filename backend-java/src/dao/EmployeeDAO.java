package dao;

import config.DatabaseConnection;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public void insertEmployee(Employee employee) {
        String sql = "INSERT INTO empleado(nombre, documento) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getDocument());
            stmt.executeUpdate();

            System.out.println("Empleado registrado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM empleado";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt("id_empleado"),
                        rs.getString("nombre"),
                        rs.getString("documento")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void updateEmployee(Employee employee) {
        String sql = "UPDATE empleado SET nombre=?, documento=? WHERE id_empleado=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getDocument());
            stmt.setInt(3, employee.getId());
            stmt.executeUpdate();

            System.out.println("Empleado actualizado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM empleado WHERE id_empleado=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Empleado eliminado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}