package com.jose.projetofs.controller;

import com.jose.projetofs.model.Farm;
import com.jose.projetofs.model.Plot;
import com.jose.projetofs.service.IFarmService;
import com.jose.projetofs.service.IPlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plot")
public class PlotController {

    @Autowired
    private IPlotService plotService;

    @Autowired
    private IFarmService farmService;

    @GetMapping
    public List<Plot> getAll(){
        return plotService.getAll();
    }

    @GetMapping("/id/{id}")
    public Plot getById(@PathVariable String id){
        return plotService.getById(id);
    }

    @GetMapping("/farm_id/{farmId}")
    public List<Plot> getByFarmId(@PathVariable String farmId){
        return plotService.getByFarmId(farmId);
    }

    @GetMapping("/productivity/{id}")
    public double getProductivity(@PathVariable String id){
        return plotService.getProductivityById(id);
    }

    @PostMapping
    Plot create(@RequestBody Plot plot){
        return plotService.create(plot);
    }

    @DeleteMapping("/id/{id}")
    void delete(@PathVariable String id){
        plotService.deleteById(id);
    }
}
