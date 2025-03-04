package com.example.ptuddn_3.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    // Cho phép cả ROLE_USER và ROLE_ADMIN truy cập
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/profile")
    public String getUserProfile() {
        return "User profile information.";
    }
}
