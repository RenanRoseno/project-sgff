/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.sgff.service;

import com.spring.sgff.models.UsuariosRoles;
import com.spring.sgff.repository.UsuariosRolesRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author rosen
 */
public interface UsuariosRolesService {
    
    UsuariosRoles save(UsuariosRoles usuario);
    
    public UsuariosRoles findByLogin(String login);
}
