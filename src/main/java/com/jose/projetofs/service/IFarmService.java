package com.jose.projetofs.service;

import com.jose.projetofs.model.Farm;

import java.util.List;
import java.util.Optional;

public interface IFarmService {

    public List<Farm> getAll();

    public Farm getById(String id);

    public Farm create(Farm farm);

    public List<Farm> findByName(String name);
}
