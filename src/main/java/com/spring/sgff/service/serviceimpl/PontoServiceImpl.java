/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.sgff.service.serviceimpl;

import com.spring.sgff.models.Ponto;
import com.spring.sgff.repository.PontoRepository;
import com.spring.sgff.repository.SgffRepository;
import com.spring.sgff.service.PontoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author rosen
 */
public class PontoServiceImpl implements PontoService{
    
    @Autowired
    PontoRepository pontoRepository;
       
    @Override
    public List<Ponto> findAll() {
        return pontoRepository.findAll();
    }

    @Override
    public Ponto findById(long id) {
        return pontoRepository.findById(id).get();
    }

    @Override
    public Ponto save(Ponto ponto) {
        return pontoRepository.save(ponto);
    }
    
}
