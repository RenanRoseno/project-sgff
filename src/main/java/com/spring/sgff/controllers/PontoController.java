package com.spring.sgff.controllers;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import com.spring.sgff.models.Funcionarios;
import com.spring.sgff.models.Ponto;
import com.spring.sgff.service.PontoService;
import com.spring.sgff.service.SgffService;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PontoController {

    @Autowired
    private SgffService sgffservice;

    @Autowired
    private PontoService pontoService;

    @RequestMapping(value = "/registrarponto/", method = RequestMethod.GET)
    public String registrarPonto(@RequestParam("parametro") String parametro, RedirectAttributes attributes) {

        Funcionarios funcionario = sgffservice.findByCpf(parametro);

        if (!(funcionario == null)) {
            Ponto ponto = new Ponto();
            Calendar data = Calendar.getInstance();
            int hora = data.get(Calendar.HOUR_OF_DAY);
            int min = data.get(Calendar.MINUTE);
            int seg = data.get(Calendar.SECOND);

            String horaS = (hora < 10) ? "0" + Integer.toString(hora) : Integer.toString(hora);
            String minutoS = (hora < 10) ? "0" + Integer.toString(min) : Integer.toString(min);
            String segundoS = (hora < 10) ? "0" + Integer.toString(seg) : Integer.toString(seg);

            ponto.setData(LocalDate.now());

            if (hora < 17) {
                ponto.setHorarioEntrada(horaS + ":" + minutoS + ":" + segundoS);
                ponto.setHorarioSaida("-");
            } else {
                ponto.setHorarioEntrada(horaS + ":" + minutoS + ":" + segundoS);
                ponto.setHorarioSaida(horaS + ":" + minutoS + ":" + segundoS);
            }

            ponto.setId_funcionario(funcionario.getId());
            ponto.setFalta(0);

            pontoService.save(ponto);
            attributes.addFlashAttribute("mensagem", "Ok");
            return "redirect:/";
        }

        attributes.addFlashAttribute("mensagem", "Funcionário inválido");
        return "redirect:/funcionarios";
    }

    // Ver todos pontos
    @RequestMapping(value = "/pontos", method = RequestMethod.GET)
    public ModelAndView verPontos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pontosDetails");

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = Calendar.getInstance().get(Calendar.YEAR);

        String mm = (month < 10) ? "0" + Integer.toString(month) : Integer.toString(month);
        String dataIn = Integer.toString(year) + "-" + mm + "-" + "01";
        String dataFi = Integer.toString(year) + "-" + mm + "-" + "31";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateI = LocalDate.parse(dataIn, formatter);
        LocalDate dateF = LocalDate.parse(dataFi, formatter);

        String cpf = SecurityContextHolder.getContext().getAuthentication().getName();
        long id_func = sgffservice.findByCpf(cpf).getId();

        List<Ponto> pontos = pontoService.getPontosFuncionario(id_func, dateI, dateF);

        mv.addObject("pontos", pontos);
        return mv;
    }
}
