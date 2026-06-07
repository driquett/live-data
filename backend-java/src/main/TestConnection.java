package main;

import config.DatabaseConnection;
import java.sql.Connection;

public class TestConnection {

    public static void main(String[] args) {

        try {

            Connection connection =
                    DatabaseConnection.getConnection();

            System.out.println(
                    "CONEXION EXITOSA A LED_System"
            );

            connection.close();

        } catch (Exception e) {

            System.out.println(
                    "ERROR DE CONEXION"
            );

            e.printStackTrace();
        }
    }
}