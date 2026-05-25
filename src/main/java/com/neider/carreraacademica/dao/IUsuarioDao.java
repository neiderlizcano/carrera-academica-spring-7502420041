package com.neider.carreraacademica.dao;

import com.neider.carreraacademica.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository<Usuario, String> {
}