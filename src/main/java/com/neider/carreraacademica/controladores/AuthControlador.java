package com.neider.carreraacademica.controladores;

import com.neider.carreraacademica.modelo.Usuario;
import com.neider.carreraacademica.servicio.IUsuarioServicio;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AuthControlador {

    private final IUsuarioServicio usuarioServicio;

    public AuthControlador(IUsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @GetMapping("/login")
    public String mostrarLogin(@RequestParam(value = "requerido", required = false) String requerido,
                               Model model) {

        if (requerido != null) {
            model.addAttribute("error", "Debes iniciar sesión para acceder a esta sección.");
        }

        return "auth/login";
    }

    @PostMapping("/login")
    public String iniciarSesion(@RequestParam String email,
                                @RequestParam String clave,
                                HttpSession session,
                                Model model) {

        Optional<Usuario> usuarioEncontrado = usuarioServicio.validarLogin(email, clave);

        if (usuarioEncontrado.isPresent()) {
            session.setAttribute("usuarioLogueado", usuarioEncontrado.get());
            return "redirect:/";
        }

        model.addAttribute("error", "Correo o contraseña incorrectos.");
        return "auth/login";
    }

    @GetMapping("/logout")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/recuperar")
    public String mostrarRecuperarContrasena() {
        return "auth/recuperar";
    }

    @PostMapping("/recuperar")
    public String recuperarContrasena(@RequestParam String email,
                                      @RequestParam String nuevaClave,
                                      Model model) {

        Optional<Usuario> usuarioEncontrado = usuarioServicio.buscarUsuarioPorEmail(email);

        if (usuarioEncontrado.isEmpty()) {
            model.addAttribute("error", "No existe un usuario registrado con ese correo.");
            return "auth/recuperar";
        }

        usuarioServicio.actualizarClave(email, nuevaClave);
        model.addAttribute("mensaje", "Contraseña actualizada correctamente. Ya puedes iniciar sesión.");
        return "auth/login";
    }
}