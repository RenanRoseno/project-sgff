package com.spring.sgff.repository;

import com.spring.sgff.models.Cargo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
    
}
