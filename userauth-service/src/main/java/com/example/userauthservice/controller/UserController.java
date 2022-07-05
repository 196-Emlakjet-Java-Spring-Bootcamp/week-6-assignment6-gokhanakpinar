package com.example.userauthservice.controller;

import com.example.userauthservice.dto.UserLoginRequest;
import com.example.userauthservice.dto.UserRequest;
import com.example.userauthservice.entity.User;
import com.example.userauthservice.security.JwtUtil;
import com.example.userauthservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody UserRequest userRequest){
        userService.save(userRequest);
    }

    @PostMapping("/login")
    public String createToken(@RequestBody UserLoginRequest userLoginRequest) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLoginRequest.getUsername(), userLoginRequest.getPassword()));
        }catch (BadCredentialsException exception){
            throw new Exception("Incorrect username or password", exception);
        }
        final UserDetails userDetails = userService.loadUserByUsername(userLoginRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return jwt;
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }
}
