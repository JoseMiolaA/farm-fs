package com.jose.projetofs.controller;

import com.jose.projetofs.model.Farm;
import com.jose.projetofs.model.Plot;
import com.jose.projetofs.service.IFarmService;
import com.jose.projetofs.service.IPlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Plot>> getAll(){
        List<Plot> plots = plotService.getAll();
        return ResponseEntity.ok().body(plots);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Plot> getById(@PathVariable String id){
        Plot plot = plotService.getById(id);
        return ResponseEntity.ok().body(plot);
    }

    @GetMapping("/farm_id/{farmId}")
    public ResponseEntity<List<Plot>> getByFarmId(@PathVariable String farmId){
        List<Plot> plots = plotService.getByFarmId(farmId);
        return ResponseEntity.ok().body(plots);
    }

    @GetMapping("/productivity/{id}")
    public ResponseEntity<Double> getProductivity(@PathVariable String id){
        double productivity = plotService.getProductivityById(id);
        return ResponseEntity.ok().body(productivity);
    }

    @PostMapping
    public ResponseEntity<Plot> create(@RequestBody Plot plot){
        Plot createdPlot = plotService.create(plot);
        return ResponseEntity.ok().body(createdPlot);
    }

    @DeleteMapping("/id/{id}")
    void delete(@PathVariable String id){
        plotService.deleteById(id);
    }
}
