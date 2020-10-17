package com.spring.sgff.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AutenticationController {

    // Login
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login?error=true", method = RequestMethod.GET)
    public String loginError() {
        System.out.println("Erro ao logar");
        return "login";
    }

    // Logout session
    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }
}
