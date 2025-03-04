package com.example.ptuddn_3.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/profile")
    public String getUserProfile() {
        return "User profile information.";
    }
}
