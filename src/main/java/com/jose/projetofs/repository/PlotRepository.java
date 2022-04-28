package com.jose.projetofs.repository;

import com.jose.projetofs.model.Plot;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlotRepository extends MongoRepository<Plot, String> {
}
