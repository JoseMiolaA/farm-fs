package com.jose.projetofs.repository;

import com.jose.projetofs.model.Farm;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FarmRepository extends MongoRepository <Farm, String> {
     List<Farm> findByName(String name);
}