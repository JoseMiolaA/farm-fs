package com.jose.projetofs.controller;

import com.jose.projetofs.model.Farm;
import com.jose.projetofs.model.Plot;
import com.jose.projetofs.service.IFarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/farm")
public class FarmController {


    @Autowired
    private IFarmService farmService;

    @GetMapping("/teste")
    public int getTeste(){
        return 12;
    }


    @GetMapping
    public List<Farm> getAll(){
        return farmService.getAll();
    }

    @GetMapping("/{id}")
    public Farm getById(@PathVariable String id){
        return farmService.getById(id);
    }

    @PostMapping
    public Farm create(@RequestBody Farm farm){
        return farmService.create(farm);
        /*
        List<Plot> testPlots = new ArrayList<>();
        Plot testPlot = new Plot("plot teste1", 2, 3);
        testPlots.add(testPlot);
        testPlots.add(testPlot);
        Farm testFarm = new Farm("testFarm", testPlots);
        System.out.println(testFarm);
        return farmService.create(testFarm);
        */
    }
}
