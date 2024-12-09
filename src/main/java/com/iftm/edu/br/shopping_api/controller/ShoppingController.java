package com.iftm.edu.br.shopping_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.iftm.edu.br.shopping_api.models.Shopping;
import com.iftm.edu.br.shopping_api.services.ShoppingService;

import java.util.List;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService;

    @PostMapping
    public ResponseEntity<Shopping> createShopping(@RequestBody Shopping shopping) {
        return ResponseEntity.ok(shoppingService.save(shopping));
    }

    @GetMapping
    public ResponseEntity<List<Shopping>> getAllShopping() {
        return ResponseEntity.ok(shoppingService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shopping> getShoppingById(@PathVariable String id) {
        return shoppingService.findById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/shopByUser/{userId}")
    public ResponseEntity<List<Shopping>> getShoppingByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(shoppingService.findByUserId(userId));
    }

    @GetMapping("/shopByDate/{date}")
    public ResponseEntity<List<Shopping>> getShoppingByDate(@PathVariable String date) {
        return ResponseEntity.ok(shoppingService.findByDate(date));
    }
}

