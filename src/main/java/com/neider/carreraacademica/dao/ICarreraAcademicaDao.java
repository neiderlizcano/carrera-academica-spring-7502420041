package com.neider.carreraacademica.dao;

import com.neider.carreraacademica.modelo.CarreraAcademica;
import org.springframework.data.repository.CrudRepository;

public interface ICarreraAcademicaDao extends CrudRepository<CarreraAcademica, Long> {
}