package com.iftm.edu.br.user_api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.iftm.edu.br.user_api.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByCpf(String cpf);
    List<User> findByNameContaining(String name);
}

