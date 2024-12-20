package com.iftm.edu.br.user_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.iftm.edu.br.user_api.models.User;
import com.iftm.edu.br.user_api.models.dto.UserDTO;
import com.iftm.edu.br.user_api.services.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    private UserDTO convertToDTO(User user) {
        return new UserDTO(
            user.getId(),
            user.getName(),
            user.getCpf(),
            user.getEmail()
        );
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody User user) {
        User savedUser = userService.save(user);
        return ResponseEntity.ok(convertToDTO(savedUser));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userDTOs = userService.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userDTOs);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        Optional<User> user = userService.findById(id);
        return user.map(u -> ResponseEntity.ok(convertToDTO(u)))
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/findByCPF/{cpf}")
    public ResponseEntity<UserDTO> findByCpf(@PathVariable String cpf) {
        Optional<User> user = userService.findByCpf(cpf);
        return user.map(u -> ResponseEntity.ok(convertToDTO(u)))
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<UserDTO>> findByName(@PathVariable String name) {
        List<UserDTO> userDTOs = userService.findByName(name).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userDTOs);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String id, @RequestBody User user) {
        user.setId(id);
        User updatedUser = userService.save(user);
        return ResponseEntity.ok(convertToDTO(updatedUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        if (userService.findById(id).isPresent()) {
            userService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
