package com.iftm.edu.br.shopping_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iftm.edu.br.shopping_api.models.Shopping;
import com.iftm.edu.br.shopping_api.repositories.ShoppingRepository;

@Service
public class ShoppingService {

    @Autowired
    private ShoppingRepository shoppingRepository;

    public Shopping save(Shopping shopping) {
        return shoppingRepository.save(shopping);
    }

    public List<Shopping> findAll() {
        return shoppingRepository.findAll();
    }

    public Optional<Shopping> findById(String id) {
        return shoppingRepository.findById(id);
    }

    public List<Shopping> findByUserId(String userId) {
        return shoppingRepository.findByUserId(userId);
    }

    public List<Shopping> findByDate(String date) {
        return shoppingRepository.findByDate(date);
    }
}

