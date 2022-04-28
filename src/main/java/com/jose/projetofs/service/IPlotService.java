package com.jose.projetofs.service;

import com.jose.projetofs.model.Farm;
import com.jose.projetofs.model.Plot;

import java.util.List;
import java.util.Optional;

public interface IPlotService {
    public List<Plot> getAll();

    public Optional<Plot> getById(String id);

    public Plot create(Farm Plot);
}
