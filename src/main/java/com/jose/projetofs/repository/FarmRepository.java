package com.jose.projetofs.repository;

import com.jose.projetofs.model.Farm;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FarmRepository extends MongoRepository <Farm, String> {
}
