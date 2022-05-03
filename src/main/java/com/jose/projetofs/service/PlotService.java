package com.jose.projetofs.service;

import com.jose.projetofs.model.Farm;
import com.jose.projetofs.model.Plot;
import com.jose.projetofs.repository.FarmRepository;
import com.jose.projetofs.repository.PlotRepository;
import com.jose.projetofs.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlotService implements IPlotService{
    
    @Autowired
    private PlotRepository plotRepository;

    @Override
    public List<Plot> getAll() {
        return plotRepository.findAll();
    }
    
    @Override
    public Plot getById(String id) {
        return plotRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Id not found " + id));
    }

    @Override
    public List<Plot> getByFarmId(String id) {
        return plotRepository.findByFarmId(id);
    }

    @Override
    public Plot create(Plot plot) {
        return plotRepository.save(plot);
    }

    @Override
    public void deleteById(String id) {
        plotRepository.deleteById(id);
    }

    @Override
    public double getProductivityById(String id) {
       return getById(id).calculateProductivity();
    }
}
