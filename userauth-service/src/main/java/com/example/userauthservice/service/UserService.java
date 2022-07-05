package com.example.userauthservice.service;

import com.example.userauthservice.dao.UserRepository;
import com.example.userauthservice.dto.UserRequest;
import com.example.userauthservice.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public void save(UserRequest userRequest){
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username);
    }
}
