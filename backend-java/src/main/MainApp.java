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
            System.out.println("5. Actualizar empleado");
            System.out.println("6. Eliminar empleado");
            System.out.println("7. Actualizar credencial");
            System.out.println("8. Eliminar credencial");
            System.out.println("9. Salir");

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

                case 5: 
                    System.out.print("ID Empleado: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nuevo nombre: ");
                    String newName = scanner.nextLine();
                    System.out.print("Nuevo documento: ");
                    String newDocument = scanner.nextLine();
                    employeeDAO.updateEmployee(
                        new Employee(
                    updateId,
                    newName,
                    newDocument
            )
    ); break; 
    
                case 6: 
                System.out.print("ID Empleado a eliminar: ");
                int deleteId = scanner.nextInt();
                employeeDAO.deleteEmployee(deleteId);
                break;
    
            case 7:
            System.out.print("ID Credencial: ");            
            int credentialId = scanner.nextInt();
            scanner.nextLine();

    System.out.print("Nuevo codigo: ");
    String newCode = scanner.nextLine();

    System.out.print("ID empleado: ");
    int employeeId = scanner.nextInt();

    credentialDAO.updateCredential(
            new Credential(
                    credentialId,
                    newCode,
                    employeeId
            )
    );
    case 8:

    System.out.print("ID credencial a eliminar: ");
    int deleteCredentialId = scanner.nextInt();

    credentialDAO.deleteCredential(deleteCredentialId);

    break;

    }

        } while (option != 9);
        scanner.close();
    }
} 