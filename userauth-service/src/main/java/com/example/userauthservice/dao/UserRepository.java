package com.example.userauthservice.dao;

import com.example.userauthservice.dto.UserRequest;
import com.example.userauthservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User getUserByUsername(String username);

    void save(UserRequest userRequest);

    List<User> findAll();

    User findUserByUsername(String username);
}
