-- Crear base de datos
CREATE DATABASE IF NOT EXISTS sistema_credenciales;
USE sitema_credenciales;

-- Tabla de empleados
CREATE TABLE empleado (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    documento VARCHAR(20) NOT NULL
);

-- Tabla de credenciales
CREATE TABLE credencial (
    id_credencial INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(50) NOT NULL,
    id_empleado INT NOT NULL,
    CONSTRAINT fk_credencial_empleado
        FOREIGN KEY (id_empleado)
        REFERENCES empleado(id_empleado)
);

-- Datos de prueba (opcional)
INSERT INTO empleado (nombre, documento)
VALUES
('Juan Perez', '12345678'),
('Maria Gomez', '87654321');

INSERT INTO credencial (codigo, id_empleado)
VALUES
('CRED-001', 1),
('CRED-002', 2);