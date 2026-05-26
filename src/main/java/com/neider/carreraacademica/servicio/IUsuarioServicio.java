package com.neider.carreraacademica.servicio;

import com.neider.carreraacademica.modelo.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioServicio {

    List<Usuario> listarUsuarios();

    void guardarUsuario(Usuario usuario);

    Optional<Usuario> buscarUsuarioPorCedula(String cedula);

    void eliminarUsuario(String cedula);

    Optional<Usuario> validarLogin(String email, String clave);
}