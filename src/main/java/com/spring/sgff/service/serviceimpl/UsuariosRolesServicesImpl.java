/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.sgff.service.serviceimpl;

import com.spring.sgff.models.UsuariosRoles;
import com.spring.sgff.repository.CargoRepository;
import com.spring.sgff.repository.UsuariosRolesRepository;
import com.spring.sgff.service.UsuariosRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rosen
 */
@Service
public class UsuariosRolesServicesImpl implements UsuariosRolesService{
    @Autowired
    UsuariosRolesRepository urRepository;
     
    @Override
    public UsuariosRoles save(UsuariosRoles usuario) {
        return urRepository.save(usuario);
    }

    @Override
    public UsuariosRoles findByLogin(String login) {
        return urRepository.findByLogin(login);
    }
    
}
