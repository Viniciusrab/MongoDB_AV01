package com.iftm.edu.br.product_api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iftm.edu.br.product_api.models.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByCategory(String category);
}
