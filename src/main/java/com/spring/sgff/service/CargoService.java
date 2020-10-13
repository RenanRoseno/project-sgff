package com.spring.sgff.service;

import com.spring.sgff.models.Cargo;
import java.util.List;

public interface CargoService {
    List<Cargo> findAll();
    
    Cargo saveCargo(Cargo cargo);
}
