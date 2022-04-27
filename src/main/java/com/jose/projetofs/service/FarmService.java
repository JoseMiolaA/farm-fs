package com.jose.projetofs.service;

import com.jose.projetofs.model.Farm;
import com.jose.projetofs.repository.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmService implements IFarmService{

    @Autowired
    private FarmRepository farmRepository;

    @Override
    public List<Farm> getAll() {
        return this.farmRepository.findAll();
    }

    @Override
    public Farm getById(String id) {
        return farmRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id not found"));
    }

    @Override
    public Farm create(Farm farm) {
        return farmRepository.save(farm);
    }
}
