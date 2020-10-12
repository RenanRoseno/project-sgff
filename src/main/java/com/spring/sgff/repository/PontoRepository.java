package com.spring.sgff.repository;

import com.spring.sgff.models.Ponto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PontoRepository extends JpaRepository<Ponto, Long> {
  
}
