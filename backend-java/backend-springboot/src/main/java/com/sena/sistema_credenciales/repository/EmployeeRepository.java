package com.sena.sistema_credenciales.repository;

import com.sena.sistema_credenciales.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la gestión de empleados.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}