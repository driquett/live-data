package com.sena.sistema_credenciales.service;

import com.sena.sistema_credenciales.entity.Employee;
import com.sena.sistema_credenciales.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio encargado de la lógica de negocio
 * para la gestión de empleados.
 */
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    /**
     * Constructor con inyección de dependencias.
     */
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Obtiene todos los empleados.
     */
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /**
     * Obtiene un empleado por su ID.
     */
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    /**
     * Guarda un nuevo empleado o actualiza uno existente.
     */
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     * Elimina un empleado por su ID.
     */
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}