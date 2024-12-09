package com.iftm.edu.br.product_api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iftm.edu.br.product_api.models.Product;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByCategory(String category);
}

