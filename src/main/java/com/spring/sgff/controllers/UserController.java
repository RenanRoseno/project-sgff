package com.spring.sgff.controllers;

import com.spring.sgff.models.Usuario;
import com.spring.sgff.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    public Usuario saveUsuario(Usuario user) {
        return userService.saveUsuario(user);
    }
}
