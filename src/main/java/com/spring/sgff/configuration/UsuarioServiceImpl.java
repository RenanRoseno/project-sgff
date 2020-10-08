/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.sgff.configuration;

import com.spring.sgff.models.Usuario;
import com.spring.sgff.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rosen
 */
@Repository
public class UsuarioServiceImpl implements UserDetailsService{
    
    @Autowired
    private UsuarioRepository ur;
    
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = ur.getUserByUsername(login);
        
        if(usuario == null){
            throw new UsernameNotFoundException("Usuário Inválido");
        }
        
        return usuario;
    }
    
}
