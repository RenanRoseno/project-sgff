package com.spring.sgff.service.serviceimpl;

import com.spring.sgff.models.Funcionarios;
import com.spring.sgff.repository.SgffRepository;
import com.spring.sgff.service.SgffService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SgffServiceImpl implements SgffService {

    @Autowired
    SgffRepository sgffRepository;

    @Override
    public List<Funcionarios> findAll() {
        return sgffRepository.findAll();
    }

    @Override
    public Funcionarios findById(long id) {
        return sgffRepository.findById(id).get();
    }

    @Override
    public Funcionarios save(Funcionarios funcionario) {
        return sgffRepository.save(funcionario);
    }

    @Override
    public void deleteFuncionario(long id) {
        sgffRepository.deleteById(id);
    }

    @Override
    public Funcionarios findByCpf(String cpf) {
        return sgffRepository.findByCpf(cpf);
    }

    @Override
    public Funcionarios updateFuncionarios(Funcionarios funcionario) {
        Funcionarios filteredEmployee = null;
        try {
            filteredEmployee = sgffRepository.getOne(funcionario.getId());
        } catch (Exception e) {
            e.getMessage();
        }
        if (filteredEmployee != null) {
            filteredEmployee.setNome(funcionario.getNome());
            filteredEmployee.setCpf(funcionario.getCpf());
            filteredEmployee.setCargo(funcionario.getCargo());
            filteredEmployee.setEmail(funcionario.getEmail());
            filteredEmployee.setTelefone(funcionario.getTelefone());
            filteredEmployee.setRg(funcionario.getRg());
            filteredEmployee.setDataAdmissao(funcionario.getDataAdmissao());
            filteredEmployee.setSenha(new BCryptPasswordEncoder().encode(funcionario.getSenha()));
            sgffRepository.save(filteredEmployee);
        }
        return filteredEmployee;
    }

}
