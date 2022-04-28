package com.jose.projetofs.controller;

import com.jose.projetofs.model.Farm;
import com.jose.projetofs.model.Plot;
import com.jose.projetofs.service.IFarmService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Farm> getByName(@PathVariable String name){
        return farmService.findByName(name);
    }

    @GetMapping
    public List<Farm> getAll(){
        return farmService.getAll();
    }

    @GetMapping("/id/{id}")
    public Farm getById(@PathVariable String id){
        return farmService.getById(id);
    }

    @PostMapping
    public Farm create(@RequestBody Farm farm){
        return farmService.create(farm);
    }
}
