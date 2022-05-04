package com.jose.projetofs.service;

import com.jose.projetofs.dto.PlotDTO;
import com.jose.projetofs.model.Farm;
import com.jose.projetofs.model.Plot;

import java.util.List;
import java.util.Optional;

public interface IPlotService {
     List<PlotDTO> getAll();

     PlotDTO getById(String id);

     List<PlotDTO> getByName(String name);
     PlotDTO create(Plot plot);

     void deleteById(String id);

     List<PlotDTO> getByFarmId(String id);

     boolean existsById(String id);
}
