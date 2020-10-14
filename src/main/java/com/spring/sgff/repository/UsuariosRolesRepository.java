/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.sgff.repository;

import com.spring.sgff.models.UsuariosRoles;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author rosen
 */
public interface UsuariosRolesRepository extends CrudRepository<UsuariosRoles, String>{
    
    @Query("SELECT ur FROM UsuariosRoles ur WHERE ur.usuario_id = :login")
    public UsuariosRoles findByLogin(@Param("login") String login);
}
