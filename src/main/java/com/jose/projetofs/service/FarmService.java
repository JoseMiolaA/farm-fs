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

    @Autowired
    private PlotService plotService;

    @Override
    public List<Farm> getAll() {
        return this.farmRepository.findAll();
    }

    @Override
    public Optional<Farm> getById(String id) {
        return farmRepository.findById(id);
    }

    @Override
    public double getArea(String id) {
        return plotService.getByFarmId(id)
                .stream()
                .mapToDouble(x -> x.getArea())
                .sum();
    }

    @Override
    public double getProduction(String id) {
        return plotService.getByFarmId(id)
                .stream()
                .mapToDouble(x -> x.getProduction())
                .sum();
    }
    @Override
    public double getProductivity(String id) {
        return getProduction(id)/getArea(id);
    }

    @Override
    public Farm create(Farm farm) {
        return farmRepository.save(farm);
    }

    @Override
    public List<Farm> findByName(String name) {
        return farmRepository.findByName(name);
    }

    @Override
     public void delete(String id) {
        farmRepository.deleteById(id);
    }

    @Override
    public boolean existsById(String id) {
        return farmRepository.existsById(id);
    }
}
