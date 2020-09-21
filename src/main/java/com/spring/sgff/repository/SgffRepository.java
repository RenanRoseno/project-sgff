
package com.spring.sgff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
import com.spring.sgff.models.Funcionarios;

/**
 *
 * @author rosen
 */
@Repository
public interface SgffRepository extends JpaRepository<Funcionarios, Long> {
    public Funcionarios findById(UUID id);

    void deleteById(UUID id);
}
