package com.spring.sgff.repository;

import com.spring.sgff.models.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {

    @Query("SELECT u FROM Usuario u WHERE u.login = :username")
    public Usuario getUserByUsername(@Param("username") String username);
}
