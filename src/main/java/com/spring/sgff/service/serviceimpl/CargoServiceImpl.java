package com.spring.sgff.service.serviceimpl;

import com.spring.sgff.models.Cargo;
import com.spring.sgff.repository.CargoRepository;
import com.spring.sgff.service.CargoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    CargoRepository cargoRepository;

    @Override
    public Cargo saveCargo(Cargo cargo) {
        return cargoRepository.save(cargo);
    }
}
