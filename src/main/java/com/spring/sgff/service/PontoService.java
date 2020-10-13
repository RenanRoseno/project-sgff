package com.spring.sgff.service;

import com.spring.sgff.models.Ponto;
import java.time.LocalDate;
import java.util.List;

public interface PontoService {
    List<Ponto> findAll();

    Ponto findById(long id);

    Ponto save(Ponto ponto);
    
    List<Ponto> getPontosFuncionario(long id_funcionario, LocalDate dataI, LocalDate dataF);

}
