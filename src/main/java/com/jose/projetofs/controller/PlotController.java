package com.jose.projetofs.controller;

import com.jose.projetofs.dto.PlotDTO;
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
    public ResponseEntity<List<PlotDTO>> getAll(){
        List<PlotDTO> plots = plotService.getAll();
        return ResponseEntity.ok().body(plots);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PlotDTO> getById(@PathVariable String id){
        PlotDTO plot = plotService.getById(id);
        return ResponseEntity.ok().body(plot);
    }

    @GetMapping("/farm_id/{farmId}")
    public ResponseEntity<List<PlotDTO>> getByFarmId(@PathVariable String farmId){
        List<PlotDTO> plots = plotService.getByFarmId(farmId);
        return ResponseEntity.ok().body(plots);
    }

    @PostMapping
    public ResponseEntity<PlotDTO> create(@RequestBody Plot plot){
        PlotDTO createdPlot = plotService.create(plot);
        return ResponseEntity.ok().body(createdPlot);
    }

    @DeleteMapping("/id/{id}")
    void delete(@PathVariable String id){
        plotService.deleteById(id);
    }
}
