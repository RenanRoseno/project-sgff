/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.sgff.service;

import com.spring.sgff.models.Ponto;
import java.util.List;

/**
 *
 * @author rosen
 */
public interface PontoService {
    List<Ponto> findAll();

    Ponto findById(long id);

    Ponto save(Ponto ponto);

}
