package com.spring.sgff.service.serviceimpl;

import com.spring.sgff.models.Cargo;
import com.spring.sgff.repository.CargoRepository;
import com.spring.sgff.service.CargoService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    CargoRepository cargoRepository;

    @Override
    public Cargo save(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    @Override
    public List<Cargo> findAll() {
        return cargoRepository.findAll();
    }
    
    @Override
    public Cargo findById(long id){
        return cargoRepository.findById(id).get();
    }
    
    @Override
    public Cargo updateCargo(Cargo cargo){
        Cargo cargoA = null;
        try{
            cargoA = cargoRepository.getOne(cargo.getId());
        }catch(Exception e){
            e.getMessage();
        }
        if(cargoA != null){
            cargoA.setNome(cargo.getNome());
            cargoA.setDescricao(cargo.getDescricao());
            
            cargoRepository.save(cargoA);
        }
        return cargoA;
    }
    
    @Override
    public void deleteCargo(long id){
       cargoRepository.deleteById(id);
    }
}
