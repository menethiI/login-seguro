package br.com.app.login_seguro.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.app.login_seguro.model.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}