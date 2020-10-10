package com.spring.sgff.service.serviceimpl;

import com.spring.sgff.models.Usuario;
import com.spring.sgff.repository.UsuarioRepository;
import com.spring.sgff.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UsuarioRepository userRepository;

    @Override
    public Usuario saveUsuario(Usuario user) {
        return userRepository.save(user);
    }

}
