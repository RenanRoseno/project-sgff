/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.sgff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.sgff.models.Funcionarios;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author rosen
 */
public interface SgffRepository extends JpaRepository<Funcionarios, Long> {
    @Query("SELECT f FROM Funcionarios f WHERE f.cpf = ?1")
    Funcionarios findByCpf(String cpf);
}
