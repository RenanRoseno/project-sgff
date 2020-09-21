
package com.spring.sgff.service.serviceimpl;

import com.spring.sgff.models.Funcionarios;
import com.spring.sgff.repository.SgffRepository;
import com.spring.sgff.service.SgffService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rosen
 */

@Service
public class SgffServiceImpl implements SgffService {

    @Autowired
    SgffRepository sgffRepository;

    @Override
    public List<Funcionarios> findAll() {
        return sgffRepository.findAll();
    }

    @Override
    public Funcionarios findById(UUID id) {
        return sgffRepository.findById(id);
    }

    @Override
    public Funcionarios save(Funcionarios funcionario) {
        return sgffRepository.save(funcionario);
    }

    @Override
    public void deleteById(UUID id) {
        sgffRepository.deleteById(id);
    }

}
