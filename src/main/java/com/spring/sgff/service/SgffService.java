/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.sgff.service;

import com.spring.sgff.models.Funcionarios;
import com.spring.sgff.models.Ponto;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author rosen
 */

public interface SgffService {
    List<Funcionarios> findAll();

    Funcionarios findById(long id);
    
    Funcionarios findByCpf(String cpf);

    Funcionarios save(Funcionarios funcionario);

    void deleteFuncionario(long id);
}
