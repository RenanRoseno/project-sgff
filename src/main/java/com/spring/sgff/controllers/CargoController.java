package com.spring.sgff.controllers;

import javax.validation.Valid;
import com.spring.sgff.models.Cargo;
import com.spring.sgff.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CargoController {

    @Autowired
    CargoService cargoService;

    @RequestMapping(value = "/newCargo", method = RequestMethod.POST)
    public String createCargo(@Valid Cargo cargo, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os dados digitados");
            return "redirect:/newCargo/";
        }

        cargoService.saveCargo(cargo);

        return "redirect:/funcionarios";
    }

    @RequestMapping(value = "/newCargo", method = RequestMethod.GET)
    public String getFuncionarioForm() {
        return "cargoForm";
    }

}
