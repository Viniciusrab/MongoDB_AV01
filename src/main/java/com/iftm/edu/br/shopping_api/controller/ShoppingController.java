package com.iftm.edu.br.shopping_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.iftm.edu.br.shopping_api.models.Shopping;
import com.iftm.edu.br.shopping_api.models.dto.ShoppingDTO;
import com.iftm.edu.br.shopping_api.services.ShoppingService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService;

    // Converte Shopping para ShoppingDTO
    private ShoppingDTO convertToDTO(Shopping shopping) {
        return new ShoppingDTO(
            shopping.getId(),
            shopping.getUserId(),
            shopping.getProductIds(),
            0
        );
    }

    @PostMapping
    public ResponseEntity<ShoppingDTO> createShopping(@RequestBody Shopping shopping) {
        Shopping savedShopping = shoppingService.save(shopping);
        return ResponseEntity.ok(convertToDTO(savedShopping));
    }

    @GetMapping
    public ResponseEntity<List<ShoppingDTO>> getAllShopping() {
        List<ShoppingDTO> shoppingDTOs = shoppingService.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(shoppingDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingDTO> getShoppingById(@PathVariable String id) {
        return shoppingService.findById(id)
            .map(shopping -> ResponseEntity.ok(convertToDTO(shopping)))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/shopByUser/{userId}")
    public ResponseEntity<List<ShoppingDTO>> getShoppingByUserId(@PathVariable String userId) {
        List<ShoppingDTO> shoppingDTOs = shoppingService.findByUserId(userId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(shoppingDTOs);
    }

    @GetMapping("/shopByDate/{date}")
    public ResponseEntity<List<ShoppingDTO>> getShoppingByDate(@PathVariable String date) {
        List<ShoppingDTO> shoppingDTOs = shoppingService.findByDate(date).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(shoppingDTOs);
    }
}
