package com.neider.carreraacademica.servicio;

import com.neider.carreraacademica.dao.IUsuarioDao;
import com.neider.carreraacademica.modelo.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicioImpl implements IUsuarioServicio {

    private final IUsuarioDao usuarioDao;

    public UsuarioServicioImpl(IUsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    public Optional<Usuario> buscarUsuarioPorCedula(String cedula) {
        return usuarioDao.findById(cedula);
    }

    @Override
    public void eliminarUsuario(String cedula) {
        usuarioDao.deleteById(cedula);
    }
}