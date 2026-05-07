package main;

import dao.EmployeeDAO;
import dao.CredentialDAO;
import model.Employee;
import model.Credential;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EmployeeDAO employeeDAO = new EmployeeDAO();
        CredentialDAO credentialDAO = new CredentialDAO();

        int option;

        do {
            System.out.println("\n--- SISTEMA DE GESTION ---");
            System.out.println("1. Registrar empleado");
            System.out.println("2. Listar empleados");
            System.out.println("3. Crear credencial");
            System.out.println("4. Listar credenciales");
            System.out.println("5. Salir");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1:
                    System.out.print("Nombre: ");
                    String name = scanner.nextLine();

                    System.out.print("Documento: ");
                    String doc = scanner.nextLine();

                    employeeDAO.insertEmployee(new Employee(0, name, doc));
                    break;

                case 2:
                    employeeDAO.getEmployees().forEach(e ->
                            System.out.println(e.getId() + " - " + e.getName()));
                    break;

                case 3:
                    System.out.print("Código credencial: ");
                    String code = scanner.nextLine();

                    System.out.print("ID empleado: ");
                    int empId = scanner.nextInt();

                    credentialDAO.insertCredential(new Credential(0, code, empId));
                    break;

                case 4:
                    credentialDAO.getCredentials().forEach(c ->
                            System.out.println(c.getId() + " - " + c.getCode()));
                    break;
            }

        } while (option != 5);
    }
}