
package com.spring.sgff.service;

import com.spring.sgff.models.Funcionarios;
import java.util.List;

/**
 *
 * @author rosen
 */

public interface SgffService {
    List<Funcionarios> findAll();

    Funcionarios findById(Long id);

    Funcionarios save(Funcionarios funcionario);

    void deleteById(Long id);
}
