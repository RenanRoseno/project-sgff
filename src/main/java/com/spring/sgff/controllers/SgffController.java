package com.spring.sgff.controllers;

import com.spring.sgff.models.Funcionarios;
import com.spring.sgff.models.Ponto;
import com.spring.sgff.models.Usuario;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SgffController {

    @Autowired
    private SgffService sgffservice;

    @Autowired
    private UserController userController;

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

    // Chamando a págiona de formulário para add um novo funcionário
    @RequestMapping(value = "/newfuncionario/", method = RequestMethod.GET)
    public String getFuncionarioForm() {
        return "FuncionarioForm";
    }

    // Cria um novo funcionário e um novo usuário no banco
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
        String password = funcionario.getSenha();
        long id = funcionario.getId();
        String login = funcionario.getCpf();
        Usuario newUser = new Usuario(login, id, password);
        userController.saveUsuario(newUser);
        return "redirect:/funcionarios/";
    }

    @RequestMapping(value = "/funcionarios/{id}", method = RequestMethod.POST)
    public String requestMethodName(@Valid Funcionarios funcionario) {
        Funcionarios updatedEmployee = sgffservice.updateFuncionarios(funcionario);

        String password = updatedEmployee.getSenha();
        long id = updatedEmployee.getId();
        String login = updatedEmployee.getCpf();
        Usuario newUser = new Usuario(login, id, password);

        userController.saveUsuario(newUser);
        return "redirect:/funcionarios/";
    }

    // Deleta um funcionário pelo id
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteFuncionario(@PathVariable("id") long id) {
        sgffservice.deleteFuncionario(id);
        return "redirect:/funcionarios/";
    }
}
