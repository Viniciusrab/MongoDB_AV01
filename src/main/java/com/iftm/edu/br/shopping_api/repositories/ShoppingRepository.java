package com.iftm.edu.br.shopping_api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iftm.edu.br.shopping_api.models.Shopping;

public interface ShoppingRepository extends MongoRepository<Shopping, String> {
    List<Shopping> findByUserId(String userId);
    List<Shopping> findByDate(String date);
}

