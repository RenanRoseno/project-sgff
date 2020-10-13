package com.spring.sgff.controllers;

import javax.validation.Valid;
import com.spring.sgff.models.Cargo;
import com.spring.sgff.service.CargoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CargoController {

    @Autowired
    CargoService cargoService;

    @RequestMapping(value = "/newCargo/", method = RequestMethod.POST)
    public String saveCargo(@Valid Cargo cargo, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {

            System.out.println(result.toString());
            System.out.println(cargo.getDescricao());
            attributes.addFlashAttribute("mensagem", "Verifique os dados digitados");
            return "redirect:/newCargo/";
        }

        cargoService.save(cargo);

        return "redirect:/cargos/";
    }

    @RequestMapping(value = "/newCargo/", method = RequestMethod.GET)
    public String getFuncionarioForm() {
        return "cargoForm";
    }

    @RequestMapping(value = "/cargos/", method = RequestMethod.GET)
    public ModelAndView getCargos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cargosList");

        List<Cargo> cargos = cargoService.findAll();
        mv.addObject("cargos", cargos);

        return mv;
    }

    @RequestMapping(value = "/cargos/{id}", method = RequestMethod.GET)
    public ModelAndView cargosDetails(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cargoDetails");

        Cargo cargo = cargoService.findById(id);
        mv.addObject("cargo", cargo);

        return mv;
    }

    @RequestMapping(value = "/cargos/{id}", method = RequestMethod.POST)
    public String editarCargo(@Valid Cargo cargo) {
        Cargo c1 = cargoService.updateCargo(cargo);
        return "redirect:/cargos/";
    }
    
     @RequestMapping(value = "/deleteCargo/{id}", method = RequestMethod.GET)
    public String deleteCargo(@PathVariable("id") long id) {
        cargoService.deleteCargo(id);
        
        return "redirect:/cargos/";
    }
}
