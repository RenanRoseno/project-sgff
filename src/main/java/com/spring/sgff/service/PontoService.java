package com.spring.sgff.service;

import com.spring.sgff.models.Ponto;
import java.util.List;

public interface PontoService {
    List<Ponto> findAll();

    Ponto findById(long id);

    Ponto save(Ponto ponto);

}
