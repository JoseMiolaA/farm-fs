package com.jose.projetofs.controller;

import com.jose.projetofs.model.Farm;
import com.jose.projetofs.model.Plot;
import com.jose.projetofs.service.IFarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/farm")
public class FarmController {

    @Autowired
    private IFarmService farmService;

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Farm>> getByName(@PathVariable String name){
        List<Farm> farms = farmService.findByName(name);
        return ResponseEntity.ok().body(farms);
    }

    @GetMapping
    public ResponseEntity<List<Farm>> getAll(){
        List<Farm> farms = farmService.getAll();
        return ResponseEntity.ok().body(farms);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Farm> getById(@PathVariable String id){
        Farm farm = farmService.getById(id);
        return ResponseEntity.ok().body(farm);
    }

    @GetMapping("/area/{id}")
    public ResponseEntity<Double> getArea(@PathVariable String id){
        double area = farmService.getArea(id);
        return ResponseEntity.ok().body(area);
    }

    @GetMapping("/production/{id}")
    public ResponseEntity<Double> getProduction(@PathVariable String id){
        double production = farmService.getProduction(id);
        return ResponseEntity.ok().body(production);
    }

    @GetMapping("/productivity/{id}")
    public ResponseEntity<Double> getProductivity(@PathVariable String id){
        double productivity = farmService.getProductivity(id);
        return ResponseEntity.ok().body(productivity);
    }


    @PostMapping
    public ResponseEntity<Farm> create(@RequestBody Farm farm){
        Farm createdFarm = farmService.create(farm);
        return ResponseEntity.ok().body(createdFarm);
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable String id){
        farmService.delete(id);
    }
}
