package com.jose.projetofs.service;

import com.jose.projetofs.model.Farm;

import java.util.List;
import java.util.Optional;

public interface IFarmService {

     List<Farm> getAll();

     Optional<Farm> getById(String id);

     List<Farm> findByName(String name);

     Farm create(Farm farm);

     void delete(String id);

     boolean existsById(String id);

}
