package com.neider.carreraacademica.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

    @Id
    @NotBlank(message = "La cédula es obligatoria")
    @Size(min = 5, max = 15, message = "La cédula debe tener entre 5 y 15 caracteres")
    @Column(name = "cedula", nullable = false, length = 15)
    private String cedula;

    @NotBlank(message = "La clave es obligatoria")
    @Size(min = 3, max = 30, message = "La clave debe tener entre 3 y 30 caracteres")
    @Column(name = "clave", length = 30)
    private String clave;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Debe ingresar un correo válido")
    @Size(max = 50, message = "El correo no puede superar los 50 caracteres")
    @Column(name = "email", unique = true, length = 50)
    private String email;
}