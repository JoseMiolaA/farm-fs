package com.jose.projetofs.service;

import com.jose.projetofs.model.Farm;

import java.util.List;

public interface IFarmService {

     List<Farm> getAll();

     Farm getById(String id);

     List<Farm> findByName(String name);

     Farm create(Farm farm);

     void delete(String id);

     boolean existsById(String id);

     double getArea(String id);

     double getProduction(String id);

     double getProductivity(String id);

}
