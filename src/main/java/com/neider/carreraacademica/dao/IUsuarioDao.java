package com.neider.carreraacademica.dao;

import com.neider.carreraacademica.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IUsuarioDao extends CrudRepository<Usuario, String> {

    Optional<Usuario> findByEmailAndClave(String email, String clave);
}