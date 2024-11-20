package com.github.vediniz.jwtauth.repository;

import com.github.vediniz.jwtauth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
