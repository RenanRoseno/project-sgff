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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author rosen
 */
@Controller
public class SgffController {

    @Autowired
    private SgffService sgffservice;

    @Autowired
    private PontoRepository pontoRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/pontos", method = RequestMethod.GET)
    public String verPontos() {
        return "pontosDetails";
    }

    @RequestMapping(value = "/registrarponto/", method = RequestMethod.GET)
    public String registrarPonto(@RequestParam("parametro") String parametro, RedirectAttributes attributes) {

        Funcionarios funcionario = sgffservice.findByCpf(parametro);
        String senhaEn = new BCryptPasswordEncoder().encode("123");
        System.out.print(senhaEn);
        if (!(funcionario == null)) {
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
                p1.setHorarioSaida("-");
            } else {
                p1.setHorarioEntrada(horaS + ":" + minutoS + ":" + segundoS);
                p1.setHorarioSaida(horaS + ":" + minutoS + ":" + segundoS);
            }
            p1.setId_funcionario(funcionario.getId());
            p1.setFalta(0);

            attributes.addFlashAttribute("mensagem", "Ok");
            return "redirect:/";
        }

        attributes.addFlashAttribute("mensagem", "Funcionário inválido");
        return "redirect:/funcionarios";
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
        String senhaEn = new BCryptPasswordEncoder().encode(funcionario.getSenha());
        funcionario.setSenha(senhaEn);

        if (result.hasErrors()) {
            System.out.println(funcionario.toString());
            attributes.addFlashAttribute("mensagem", "Verifique os dados digitados");
            return "redirect:/newfuncionario/";
        }

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
