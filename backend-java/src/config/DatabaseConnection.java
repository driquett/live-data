package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // URL de conexión a MySQL
    private static final String URL =
            "jdbc:mysql://localhost:3306/sistema_credenciales";

    // Usuario de MySQL
    private static final String USER = "root";

    // Contraseña de MySQL
    private static final String PASSWORD = "";

    // Método para conectar
    public static Connection getConnection() {

        Connection connection = null;

        try {

            // Cargar driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Crear conexión
            connection = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println("Conexion exitosa a la base de datos");

        } catch (ClassNotFoundException e) {

            System.out.println("Driver JDBC no encontrado");
            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("Error de conexion");
            e.printStackTrace();
        }

        return connection;
    }
}