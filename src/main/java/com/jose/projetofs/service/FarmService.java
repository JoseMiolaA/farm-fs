package com.jose.projetofs.service;

import com.jose.projetofs.dto.FarmDTO;
import com.jose.projetofs.model.Farm;
import com.jose.projetofs.repository.FarmRepository;
import com.jose.projetofs.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FarmService implements IFarmService{

    @Autowired
    private FarmRepository farmRepository;

    @Autowired
    private PlotService plotService;

    @Override
    public List<FarmDTO> getAll() {
        List<Farm> farms = farmRepository.findAll();
        return farmsToDTOs(farms);
    }

    @Override
    public FarmDTO getById(String id) {
        Farm farm = farmRepository
                    .findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Id not found " + id));

        return farmToDTO(farm);
    }

    @Override
    public FarmDTO create(Farm farm) {
        Farm savedFarm = farmRepository.save(farm);
        return farmToDTO(savedFarm);
    }

    @Override
    public List<FarmDTO> getByName(String name) {
        List<Farm> farms = farmRepository.findByName(name);
        return farmsToDTOs(farms);
    }

    @Override
     public void delete(String id) {
        if(!existsById(id))
            throw new EntityNotFoundException("Id not found " + id);
        farmRepository.deleteById(id);
    }

    @Override
    public boolean existsById(String id) {
        return farmRepository.existsById(id);
    }


    private FarmDTO farmToDTO(Farm farm){
        FarmDTO farmDTO = new FarmDTO();
        farmDTO.setId(farm.getId());
        farmDTO.setName(farm.getName());
        farmDTO.setArea(getArea(farm.getId()));
        farmDTO.setTotalProduction(getProduction(farm.getId()));
        farmDTO.setProductivity(getProductivity(farm.getId()));
        return farmDTO;
    }

    private List<FarmDTO> farmsToDTOs (List<Farm> farms){
        List<FarmDTO> farmDTOs= new ArrayList<>();

        farms.forEach(s -> farmDTOs.add(farmToDTO(s)));

        return farmDTOs;
    }

    private double getArea(String id) {
        return plotService.getByFarmId(id)
                .stream()
                .mapToDouble(x -> x.getArea())
                .sum();
    }

    private double getProduction(String id) {
        return plotService.getByFarmId(id)
                .stream()
                .mapToDouble(x -> x.getTotalProduction())
                .sum();
    }
    private double getProductivity(String id) {
        return getProduction(id)/getArea(id);
    }

}
