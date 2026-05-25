package com.neider.carreraacademica.servicio;

import com.neider.carreraacademica.dao.ICarreraAcademicaDao;
import com.neider.carreraacademica.modelo.CarreraAcademica;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarreraAcademicaServicioImpl implements ICarreraAcademicaServicio {

    private final ICarreraAcademicaDao carreraAcademicaDao;

    public CarreraAcademicaServicioImpl(ICarreraAcademicaDao carreraAcademicaDao) {
        this.carreraAcademicaDao = carreraAcademicaDao;
    }

    @Override
    public List<CarreraAcademica> listarCarreras() {
        return (List<CarreraAcademica>) carreraAcademicaDao.findAll();
    }

    @Override
    public void guardarCarrera(CarreraAcademica carreraAcademica) {
        carreraAcademicaDao.save(carreraAcademica);
    }

    @Override
    public Optional<CarreraAcademica> buscarCarreraPorId(Long id) {
        return carreraAcademicaDao.findById(id);
    }

    @Override
    public void eliminarCarrera(Long id) {
        carreraAcademicaDao.deleteById(id);
    }
}