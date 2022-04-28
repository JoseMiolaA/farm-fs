package com.jose.projetofs.service;

import com.jose.projetofs.model.Farm;
import com.jose.projetofs.model.Plot;

import java.util.List;
import java.util.Optional;

public interface IPlotService {
     List<Plot> getAll();

     Optional<Plot> getById(String id);

     Plot create(Plot plot);

     void deleteById(String id);

     List<Plot> getByFarmId(String id);

     double getProductivityById(String id);
}
