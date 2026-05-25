package com.neider.carreraacademica.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "carreras_academicas")
@Data
public class CarreraAcademica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "num_creditos", nullable = false)
    private Integer numCreditos;

    @Column(name = "num_asignaturas", nullable = false)
    private Integer numAsignaturas;

    @Column(name = "num_semestres", nullable = false)
    private Integer numSemestres;

    @Column(name = "nivel_formacion", nullable = false, length = 50)
    private String nivelFormacion;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "valor_semestre", nullable = false, precision = 12, scale = 2)
    private BigDecimal valorSemestre;

    @Column(name = "universidad", nullable = false, length = 100)
    private String universidad;

    @Column(name = "es_acreditada", nullable = false)
    private Boolean esAcreditada;

    @Column(name = "perfiles", length = 500)
    private String perfiles;

    @Column(name = "area_conocimiento", nullable = false, length = 100)
    private String areaConocimiento;
}