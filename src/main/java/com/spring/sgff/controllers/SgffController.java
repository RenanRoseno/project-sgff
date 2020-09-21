
package com.spring.sgff.controllers;

import com.spring.sgff.models.Funcionarios;
import com.spring.sgff.service.SgffService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rosen
 */
@RestController
@RequestMapping({ "/funcionarios" })

public class SgffController {

    @Autowired
    SgffService sgffservice;

    @GetMapping
    public List<Funcionarios> getFuncionarios() {
        List<Funcionarios> funcionario = sgffservice.findAll();
        return funcionario;
    }

    @PostMapping
    public Funcionarios saveFuncionario(@RequestBody Funcionarios funcionario) {
        return sgffservice.save(funcionario);
    }

    @GetMapping(path = { "/{id}" })
    public Funcionarios findFuncionarioById(@PathVariable("id") UUID id) {
        return sgffservice.findById(id);
    }

    @DeleteMapping(path = { "/{id}" })
    @Transactional
    public void deleteFuncionario(@PathVariable("id") UUID id) {
        sgffservice.deleteById(id);
    }

    // --------------> Métodos das versões anteriores <---------------

    /*
     * @RequestMapping(value = "/funcionarios/{id}", method = RequestMethod.GET)
     * 
     * public ModelAndView getFuncionariosDetails(@PathVariable("id") long id) {
     * ModelAndView mv = new ModelAndView(); mv.setViewName("funcionarioDetails");
     * 
     * Funcionarios funcionario = sgffservice.findById(id);
     * mv.addObject("funcionario", funcionario);
     * 
     * return mv; }
     */
    // @RequestMapping(value = "/funcionarios", method = RequestMethod.GET)
    /*
     * public ModelAndView getFuncionarios() { ModelAndView mv = new ModelAndView();
     * mv.setViewName("Funcionarios.html");
     * 
     * List<Funcionarios> funcionarios = sgffservice.findAll();
     * mv.addObject("funcionarios", funcionarios);
     * 
     * return mv; }
     */

}
