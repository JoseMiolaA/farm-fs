package com.jose.projetofs.service;

import com.jose.projetofs.model.Farm;
import com.jose.projetofs.model.Plot;
import com.jose.projetofs.repository.PlotRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PlotService implements IPlotService{
    
    @Autowired
    private PlotRepository plotRepository;
    
    @Override
    public List<Plot> getAll() {
        return plotRepository.findAll();
    }
    
    @Override
    public Optional<Plot> getById(String id) {
        return plotRepository
                .findById(id);
                //.orElseThrow(() -> new IllegalArgumentException("Id not found"));
    }

    @Override
    public Plot create(Farm Plot) {
        return null;
    }
}
