package com.jose.projetofs.service;

import com.jose.projetofs.model.Farm;
import com.jose.projetofs.repository.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FarmService implements IFarmService{

    @Autowired
    private FarmRepository farmRepository;

    @Override
    public List<Farm> getAll() {
        return this.farmRepository.findAll();
    }

    @Override
    public Optional<Farm> getById(String id) {
        return farmRepository.findById(id);

    }

    @Override
    public Farm create(Farm farm) {
        return farmRepository.save(farm);
    }

    @Override
    public List<Farm> findByName(String name) {
        return farmRepository.findByName(name);
    }
}
