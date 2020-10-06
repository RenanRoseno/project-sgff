/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.sgff.controllers;

import com.spring.sgff.models.Funcionarios;
import com.spring.sgff.models.Ponto;
import com.spring.sgff.repository.PontoRepository;
import com.spring.sgff.service.SgffService;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import static jdk.nashorn.internal.runtime.Debug.id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author rosen
 */
@Controller
public class SgffController {

    @Autowired
    SgffService sgffservice;

    @Autowired
    PontoRepository pontoRepository;

    // Registrar Ponto
    @RequestMapping(value = "/registrarponto/", method = RequestMethod.GET)
    public String registrarPonto() {
        //Funcionarios funcionario = sgffservice.findById(id);
        Ponto p1 = new Ponto();
        Calendar data = Calendar.getInstance();
        int hora = data.get(Calendar.HOUR_OF_DAY);
        int min = data.get(Calendar.MINUTE);
        int seg = data.get(Calendar.SECOND);

        String horaS = (hora < 10) ? "0" + Integer.toString(hora) : Integer.toString(hora);
        String minutoS = (hora < 10) ? "0" + Integer.toString(min) : Integer.toString(min);
        String segundoS = (hora < 10) ? "0" + Integer.toString(seg) : Integer.toString(seg);

        p1.setData(LocalDate.now());

        if (hora < 17) {
            p1.setHorarioEntrada(horaS + ":" + minutoS + ":" + segundoS);
            p1.setHorarioSaida("123123");
        } else {
            p1.setHorarioSaida(horaS);
        }
        p1.setId_funcionario((long)1123214);
        p1.setFalta(0);
        
        pontoRepository.save(p1);
        return "redirect:/";
    }

    // Rota de que contém a lista de todos os funcionários
    @RequestMapping(value = "/funcionarios", method = RequestMethod.GET)
    public ModelAndView getFuncionarios() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("funcionarios");

        List<Funcionarios> funcionarios = sgffservice.findAll();
        mv.addObject("funcionarios", funcionarios);

        return mv;
    }

    // Listando o funcionário pelo id
    @RequestMapping(value = "/funcionarios/{id}", method = RequestMethod.GET)
    public ModelAndView getFuncionariosDetails(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("funcionarioDetails");

        Funcionarios funcionario = sgffservice.findById(id);
        mv.addObject("funcionario", funcionario);

        return mv;
    }

    @RequestMapping(value = "/newfuncionario/", method = RequestMethod.GET)
    public String getFuncionarioForm() {
        return "FuncionarioForm";
    }

    // Cria um novo funcionário
    @RequestMapping(value = "/newfuncionario/", method = RequestMethod.POST)
    public String saveFuncionario(@Valid Funcionarios funcionario, BindingResult result,
            RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os dados digitados");
            return "redirect:/newfuncionario/";
        }

        funcionario.setDataAdmissao(LocalDate.now());
        sgffservice.save(funcionario);
        return "redirect:/funcionarios/";
    }

    // Deleta um funcionário pelo id
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteFuncionario(@PathVariable("id") long id) {
        sgffservice.deleteFuncionario(id);
        return "redirect:/funcionarios/";
    }

    // Logout session
    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }
}
