/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.sgff.controllers;

import com.spring.sgff.models.Usuario;
import com.spring.sgff.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author rosen
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    public Usuario saveUsuario(Usuario user) {
        return userService.saveUsuario(user);
    }
}
