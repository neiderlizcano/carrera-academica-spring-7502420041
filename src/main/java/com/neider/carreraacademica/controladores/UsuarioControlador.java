package com.neider.carreraacademica.controladores;

import com.neider.carreraacademica.modelo.Usuario;
import com.neider.carreraacademica.servicio.IUsuarioServicio;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioControlador {

    private final IUsuarioServicio usuarioServicio;

    public UsuarioControlador(IUsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioServicio.listarUsuarios());
        return "usuarios/listar";
    }

    @GetMapping("/agregar")
    public String agregarUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/formulario";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario,
                                 BindingResult resultado) {

        if (resultado.hasErrors()) {
            return "usuarios/formulario";
        }

        usuarioServicio.guardarUsuario(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{cedula}")
    public String editarUsuario(@PathVariable String cedula, Model model) {
        Usuario usuario = usuarioServicio.buscarUsuarioPorCedula(cedula)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado: " + cedula));

        model.addAttribute("usuario", usuario);
        return "usuarios/formulario";
    }

    @GetMapping("/eliminar/{cedula}")
    public String eliminarUsuario(@PathVariable String cedula) {
        usuarioServicio.eliminarUsuario(cedula);
        return "redirect:/usuarios";
    }
}