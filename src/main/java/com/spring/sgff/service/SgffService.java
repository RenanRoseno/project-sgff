
package com.spring.sgff.service;

import com.spring.sgff.models.Funcionarios;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author rosen
 */

public interface SgffService {
    List<Funcionarios> findAll();

    Funcionarios findById(UUID id);

    Funcionarios save(Funcionarios funcionario);

    void deleteById(UUID id);
}
