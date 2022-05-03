package com.jose.projetofs.service;

import com.jose.projetofs.dto.FarmDTO;
import com.jose.projetofs.model.Farm;

import java.util.List;

public interface IFarmService {

     List<FarmDTO> getAll();

     FarmDTO getById(String id);

     List<FarmDTO> getByName(String name);

     FarmDTO create(Farm farm);

     void delete(String id);

     boolean existsById(String id);

}
