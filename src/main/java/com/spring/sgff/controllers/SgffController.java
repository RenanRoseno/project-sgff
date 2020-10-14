package com.spring.sgff.controllers;

import com.spring.sgff.models.Cargo;
import com.spring.sgff.models.Funcionarios;
import com.spring.sgff.models.Ponto;
import com.spring.sgff.models.Usuario;
import com.spring.sgff.service.CargoService;
import com.spring.sgff.service.PontoService;
import com.spring.sgff.service.SgffService;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    @Autowired
    private CargoService cargoService;

    @Autowired
    private PontoService pontoService;

    @Autowired
    private ErrorsController errorsController;

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
        List<Cargo> cargos = cargoService.findAll();
        
        mv.addObject("cargos", cargos);
        mv.addObject("funcionario", funcionario);

        return mv;
    }

    // Chamando a página de formulário para add um novo funcionário
    @RequestMapping(value = "/newfuncionario/", method = RequestMethod.GET)
    public ModelAndView getFuncionarioForm() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("FuncionarioForm");
        
        List<Cargo> cargos = cargoService.findAll();
        mv.addObject("cargos", cargos);
        
        return mv;
    }

    // Cria um novo funcionário e um novo usuário no banco
    @RequestMapping(value = "/newfuncionario/", method = RequestMethod.POST)
    public String saveFuncionario(@Valid Funcionarios funcionario, BindingResult result,
            RedirectAttributes attributes) {

        String senhaEn = new BCryptPasswordEncoder().encode(funcionario.getSenha());
        funcionario.setSenha(senhaEn);

        if (result.hasErrors()) {
            // System.out.println(funcionario.toString());
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

    // Alterando os dados de um funcionário
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

    // Página inicial
    @RequestMapping(value = "/main/", method = RequestMethod.GET)
    public ModelAndView showMain() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("main");
        String nome = "";
        int qtdFunc = sgffservice.findAll().size();
        int qtdCargo = cargoService.findAll().size();
        int qtdPonto = pontoService.findAll().size();

        nome = SecurityContextHolder.getContext().getAuthentication().getName();

        if (nome.equals("admin")) {
            nome = "admin";
        } else {
            nome = sgffservice.findByCpf(nome).getNome();
        }

        mv.addObject("nome", nome);
        mv.addObject("qtdFunc", qtdFunc);
        mv.addObject("qtdCargo", qtdCargo);
        mv.addObject("qtdPonto", qtdPonto);

        return mv;
    }

    @RequestMapping(value = "/funcionario/{id}", method = RequestMethod.GET)
    public ModelAndView verFuncionario(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("funcionarioInfo");

        Funcionarios funcionario = sgffservice.findById(id);
        mv.addObject("funcionario", funcionario);

        return mv;
    }

    @RequestMapping(value = "/perfil/", method = RequestMethod.GET)
    public ModelAndView perfil() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("funcionarioInfo");
        String nome = SecurityContextHolder.getContext().getAuthentication().getName();

        Funcionarios f1 = sgffservice.findByCpf(nome);
        List<Cargo> cargos = cargoService.findAll();
        
        mv.addObject("cargos", cargos);
        mv.addObject("funcionario", f1);

        return mv;
    }
}
