package dao;

import config.DatabaseConnection;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // INSERTAR USUARIO
    public void insertUser(User user) {

        String sql =
                "INSERT INTO usuario (nombre_usuario, password) VALUES (?, ?)";

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());

            statement.executeUpdate();

            System.out.println("Usuario insertado correctamente");

        } catch (SQLException e) {

            System.out.println("Error al insertar usuario");
            e.printStackTrace();
        }
    }

    // CONSULTAR USUARIOS
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM usuario";

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                Statement statement =
                        connection.createStatement();

                ResultSet resultSet =
                        statement.executeQuery(sql)
        ) {

            while (resultSet.next()) {

                User user = new User();

                user.setId(
                        resultSet.getInt("id_usuario")
                );

                user.setUsername(
                        resultSet.getString("nombre_usuario")
                );

                user.setPassword(
                        resultSet.getString("password")
                );

                users.add(user);
            }

        } catch (SQLException e) {

            System.out.println("Error al consultar usuarios");
            e.printStackTrace();
        }

        return users;
    }

    // ACTUALIZAR USUARIO
    public void updateUser(User user) {

        String sql =
                "UPDATE usuario SET nombre_usuario = ?, password = ? WHERE id_usuario = ?";

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getId());

            statement.executeUpdate();

            System.out.println("Usuario actualizado correctamente");

        } catch (SQLException e) {

            System.out.println("Error al actualizar usuario");
            e.printStackTrace();
        }
    }

    // ELIMINAR USUARIO
    public void deleteUser(int userId) {

        String sql =
                "DELETE FROM usuario WHERE id_usuario = ?";

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, userId);

            statement.executeUpdate();

            System.out.println("Usuario eliminado correctamente");

        } catch (SQLException e) {

            System.out.println("Error al eliminar usuario");
            e.printStackTrace();
        }
    }

    // LOGIN DE USUARIO
    public boolean authenticateUser(
            String username,
            String password
    ) {

        String sql =
                "SELECT * FROM usuario WHERE nombre_usuario = ? AND password = ?";

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet =
                    statement.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {

            System.out.println("Error en autenticacion");
            e.printStackTrace();
        }

        return false;
    }
}