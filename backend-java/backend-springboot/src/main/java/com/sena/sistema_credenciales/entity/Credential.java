package com.sena.sistema_credenciales.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "credencial")
public class Credential {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_credencial")
    private Integer id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "id_empleado")
    private Integer idEmpleado;

    public Credential() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}