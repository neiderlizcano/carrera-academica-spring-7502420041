package com.neider.carreraacademica.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

    @Id
    @Column(name = "cedula", nullable = false, length = 15)
    private String cedula;

    @Column(name = "clave", length = 30)
    private String clave;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "email", unique = true, length = 50)
    private String email;
}