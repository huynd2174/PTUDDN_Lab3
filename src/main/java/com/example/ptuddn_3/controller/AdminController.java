package com.example.ptuddn_3.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    // Admin actions, only accessible by 'ADMIN'
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/profile")
    public String adminProfile() {
        return "Admin profile information.";
    }

    // Admin actions, only accessible by 'ADMIN'
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/create")
    public String create() {
        return "Admin created a new resource.";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("/update")
    public String update() {
        return "Admin updated a resource.";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/delete")
    public String delete() {
        return "Admin deleted a resource.";
    }
}
