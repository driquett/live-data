package com.sena.sistema_credenciales.controller;

import com.sena.sistema_credenciales.entity.Employee;
import com.sena.sistema_credenciales.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // LISTAR TODOS
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    // CREAR
    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id,
                                   @RequestBody Employee employee) {

        employee.setId(id);

        return employeeService.saveEmployee(employee);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }
}