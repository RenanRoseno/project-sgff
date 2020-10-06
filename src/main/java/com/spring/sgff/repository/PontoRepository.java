/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.sgff.repository;


import com.spring.sgff.models.Ponto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rosen
 */
public interface PontoRepository extends JpaRepository<Ponto,Long>{
    
}
