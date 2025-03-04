package com.example.ptuddn_3.controller;

import com.example.ptuddn_3.entity.AuthRequest;
import com.example.ptuddn_3.entity.UserInfo;
import com.example.ptuddn_3.service.JwtService;
import com.example.ptuddn_3.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserInfoService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    // Public endpoint for welcome
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    // Public endpoint for creating a new user
    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return service.addUser(userInfo);
    }

    // Generate JWT Token
    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }

    // User profile endpoint, only accessible by 'USER'
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/user/userProfile")
    public String userProfile() {
        return "Welcome to User Profile";
    }

    // Admin profile endpoint, only accessible by 'ADMIN'
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/admin/adminProfile")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }
}

