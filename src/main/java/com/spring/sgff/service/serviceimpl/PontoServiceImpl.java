package com.spring.sgff.service.serviceimpl;

import com.spring.sgff.models.Ponto;
import com.spring.sgff.repository.PontoRepository;
import com.spring.sgff.service.PontoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PontoServiceImpl implements PontoService {

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
    
    public Ponto findByIdFuncionario(long id){
        return pontoRepository.findByIdFuncionario(id);
    }

}
