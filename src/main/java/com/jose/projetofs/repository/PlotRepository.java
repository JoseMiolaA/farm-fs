package com.jose.projetofs.repository;

import com.jose.projetofs.model.Plot;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PlotRepository extends MongoRepository<Plot, String> {

    List<Plot> findByFarmId(String id);

    @Override
    void deleteById(String s);
}
