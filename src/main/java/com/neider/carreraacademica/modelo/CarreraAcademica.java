package com.neider.carreraacademica.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "carreras_academicas")
@Data
public class CarreraAcademica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de la carrera es obligatorio")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @NotNull(message = "El número de créditos es obligatorio")
    @Positive(message = "El número de créditos debe ser mayor que cero")
    @Column(name = "num_creditos", nullable = false)
    private Integer numCreditos;

    @NotNull(message = "El número de asignaturas es obligatorio")
    @Positive(message = "El número de asignaturas debe ser mayor que cero")
    @Column(name = "num_asignaturas", nullable = false)
    private Integer numAsignaturas;

    @NotNull(message = "El número de semestres es obligatorio")
    @Positive(message = "El número de semestres debe ser mayor que cero")
    @Column(name = "num_semestres", nullable = false)
    private Integer numSemestres;

    @NotBlank(message = "El nivel de formación es obligatorio")
    @Size(max = 50, message = "El nivel de formación no puede superar los 50 caracteres")
    @Column(name = "nivel_formacion", nullable = false, length = 50)
    private String nivelFormacion;

    @NotBlank(message = "El título otorgado es obligatorio")
    @Size(max = 100, message = "El título no puede superar los 100 caracteres")
    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @NotNull(message = "El valor del semestre es obligatorio")
    @DecimalMin(value = "0.01", message = "El valor del semestre debe ser mayor que cero")
    @Column(name = "valor_semestre", nullable = false, precision = 12, scale = 2)
    private BigDecimal valorSemestre;

    @NotBlank(message = "La universidad es obligatoria")
    @Size(max = 100, message = "La universidad no puede superar los 100 caracteres")
    @Column(name = "universidad", nullable = false, length = 100)
    private String universidad;

    @NotNull(message = "Debe indicar si la carrera es acreditada")
    @Column(name = "es_acreditada", nullable = false)
    private Boolean esAcreditada;

    @Size(max = 500, message = "Los perfiles no pueden superar los 500 caracteres")
    @Column(name = "perfiles", length = 500)
    private String perfiles;

    @NotBlank(message = "El área de conocimiento es obligatoria")
    @Size(max = 100, message = "El área de conocimiento no puede superar los 100 caracteres")
    @Column(name = "area_conocimiento", nullable = false, length = 100)
    private String areaConocimiento;
}