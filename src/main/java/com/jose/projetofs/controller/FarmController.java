package com.jose.projetofs.controller;

import com.jose.projetofs.dto.FarmDTO;
import com.jose.projetofs.model.Farm;
import com.jose.projetofs.service.IFarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farm")
public class FarmController {

    @Autowired
    private IFarmService farmService;

    @GetMapping("/name/{name}")
    public ResponseEntity<List<FarmDTO>> getByName(@PathVariable String name){
        List<FarmDTO> farms = farmService.getByName(name);
        return ResponseEntity.ok().body(farms);
    }

    @GetMapping
    public ResponseEntity<List<FarmDTO>> getAll(){
        List<FarmDTO> farms = farmService.getAll();
        return ResponseEntity.ok().body(farms);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<FarmDTO> getById(@PathVariable String id){
        FarmDTO farm = farmService.getById(id);
        return ResponseEntity.ok().body(farm);
    }

    @PostMapping
    public ResponseEntity<FarmDTO> create(@RequestBody Farm farm){
        FarmDTO createdFarm = farmService.create(farm);
        return ResponseEntity.ok().body(createdFarm);
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable String id){
        farmService.delete(id);
    }

}
