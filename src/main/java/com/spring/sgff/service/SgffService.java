package com.spring.sgff.service;

import com.spring.sgff.models.Funcionarios;
import java.util.List;

public interface SgffService {
    List<Funcionarios> findAll();

    Funcionarios findById(long id);

    Funcionarios findByCpf(String cpf);

    Funcionarios save(Funcionarios funcionario);

    Funcionarios updateFuncionarios(Funcionarios funcionario);

    void deleteFuncionario(long id);
}
