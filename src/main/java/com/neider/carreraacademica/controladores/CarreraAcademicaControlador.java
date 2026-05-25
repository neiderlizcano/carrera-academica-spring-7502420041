package com.neider.carreraacademica.controladores;

import com.neider.carreraacademica.modelo.CarreraAcademica;
import com.neider.carreraacademica.servicio.ICarreraAcademicaServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/carreras")
public class CarreraAcademicaControlador {

    private final ICarreraAcademicaServicio carreraAcademicaServicio;

    public CarreraAcademicaControlador(ICarreraAcademicaServicio carreraAcademicaServicio) {
        this.carreraAcademicaServicio = carreraAcademicaServicio;
    }

    @GetMapping
    public String listarCarreras(Model model) {
        model.addAttribute("carreras", carreraAcademicaServicio.listarCarreras());
        return "carreras/listar";
    }

    @GetMapping("/agregar")
    public String agregarCarrera(Model model) {
        model.addAttribute("carrera", new CarreraAcademica());
        return "carreras/formulario";
    }

    @PostMapping("/guardar")
    public String guardarCarrera(@ModelAttribute CarreraAcademica carreraAcademica) {
        carreraAcademicaServicio.guardarCarrera(carreraAcademica);
        return "redirect:/carreras";
    }

    @GetMapping("/ver/{id}")
    public String verCarrera(@PathVariable Long id, Model model) {
        CarreraAcademica carrera = carreraAcademicaServicio.buscarCarreraPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Carrera académica no encontrada: " + id));

        model.addAttribute("carrera", carrera);
        return "carreras/detalle";
    }

    @GetMapping("/editar/{id}")
    public String editarCarrera(@PathVariable Long id, Model model) {
        CarreraAcademica carrera = carreraAcademicaServicio.buscarCarreraPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Carrera académica no encontrada: " + id));

        model.addAttribute("carrera", carrera);
        return "carreras/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCarrera(@PathVariable Long id) {
        carreraAcademicaServicio.eliminarCarrera(id);
        return "redirect:/carreras";
    }
}