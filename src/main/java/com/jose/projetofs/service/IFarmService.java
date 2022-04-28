package com.jose.projetofs.service;

import com.jose.projetofs.model.Farm;

import java.util.List;
import java.util.Optional;

public interface IFarmService {

     List<Farm> getAll();

     Optional<Farm> getById(String id);

     Farm create(Farm farm);

     List<Farm> findByName(String name);
}
