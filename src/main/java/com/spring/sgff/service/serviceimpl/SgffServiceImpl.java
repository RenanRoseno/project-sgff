/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.spring.sgff.models.Funcionarios;
import com.spring.sgff.repository.SgffRepository;
import com.spring.sgff.service.SgffService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rosen
 */

@Service
public class SgffServiceImpl implements SgffService{
    
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
    
}
