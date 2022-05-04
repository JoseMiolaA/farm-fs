package com.jose.projetofs.service;

import com.jose.projetofs.dto.PlotDTO;
import com.jose.projetofs.model.Plot;
import com.jose.projetofs.repository.FarmRepository;
import com.jose.projetofs.repository.PlotRepository;
import com.jose.projetofs.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlotService implements IPlotService{
    
    @Autowired
    private PlotRepository plotRepository;

    @Autowired
    private FarmRepository farmRepository;

    @Override
    public List<PlotDTO> getAll() {
        List<Plot> plots = plotRepository.findAll();
        return plotsToDTOs(plots);
    }
    
    @Override
    public PlotDTO getById(String id) {
        Plot plot = plotRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Id not found " + id));
        return plotToDTO(plot);
    }

    @Override
    public List<PlotDTO> getByName(String name) {
        List<Plot> plots = plotRepository.findByName(name);
        return plotsToDTOs(plots);
    }

    @Override
    public List<PlotDTO> getByFarmId(String id) {
        List<Plot> plots = plotRepository.findByFarmId(id);
        return plotsToDTOs(plots);
    }

    @Override
    public PlotDTO create(Plot plot) {
        String farmID = plot.getFarmId();

        if(!farmRepository.existsById(farmID)) {
            throw new EntityNotFoundException("Farm Id not found " + farmID);
        }
        Plot savedPlot = plotRepository.save(plot);
        return plotToDTO(savedPlot);
    }

    @Override
    public void deleteById(String id) {
        if(!existsById(id))
            throw new EntityNotFoundException("Id not found " + id);
        plotRepository.deleteById(id);
    }

    @Override
    public boolean existsById(String id) {
        return plotRepository.existsById(id);
    }

    private PlotDTO plotToDTO(Plot plot){
        PlotDTO plotDTO = new PlotDTO();

        plotDTO.setId(plot.getId());
        plotDTO.setFarmId(plot.getFarmId());
        plotDTO.setName(plot.getName());
        plotDTO.setArea(plot.getArea());
        plotDTO.setProductions((plot.getProductions()));
        plotDTO.setTotalProduction(plot.calculateTotalProduction());
        plotDTO.setProductivity(plot.calculateProductivity());

        return plotDTO;
    }
    private List<PlotDTO> plotsToDTOs (List<Plot> plots){
        List<PlotDTO> plotDTOs= new ArrayList<>();

        plots.forEach(s -> plotDTOs.add(plotToDTO(s)));

        return plotDTOs;
    }

}
