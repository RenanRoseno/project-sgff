package com.spring.sgff.service;

import com.spring.sgff.models.Cargo;
import java.util.List;

public interface CargoService {
    List<Cargo> findAll();
    
    Cargo save(Cargo cargo);
    
    Cargo findById(long id);
    
    Cargo updateCargo(Cargo cargo);
    
    void deleteCargo(long id);
}
