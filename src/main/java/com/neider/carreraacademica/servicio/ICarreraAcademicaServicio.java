package com.neider.carreraacademica.servicio;

import com.neider.carreraacademica.modelo.CarreraAcademica;

import java.util.List;
import java.util.Optional;

public interface ICarreraAcademicaServicio {

    List<CarreraAcademica> listarCarreras();

    void guardarCarrera(CarreraAcademica carreraAcademica);

    Optional<CarreraAcademica> buscarCarreraPorId(Long id);

    void eliminarCarrera(Long id);
}