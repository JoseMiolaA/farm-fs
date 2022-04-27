package com.jose.projetofs.service;

import com.jose.projetofs.model.Farm;

import java.util.List;

public interface IFarmService {

    public List<Farm> getAll();

    public Farm getById(String id);

    public Farm create(Farm farm);

}
