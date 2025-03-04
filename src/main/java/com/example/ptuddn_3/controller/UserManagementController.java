package com.example.ptuddn_3.controller;

import com.example.ptuddn_3.entity.UserInfo;
import com.example.ptuddn_3.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class UserManagementController {

    @Autowired
    private UserInfoService userInfoService;

    // GET API - Lấy danh sách tất cả người dùng (Admin)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping
    public List<UserInfo> getAllUsers() {
        return userInfoService.getAllUsers();
    }

    // POST API - Thêm người dùng mới (Admin)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
    public String addUser(@RequestBody UserInfo userInfo) {
        return userInfoService.addUser(userInfo);
    }

    // PUT API - Cập nhật thông tin người dùng (Admin)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id, @RequestBody UserInfo userInfo) {
        return userInfoService.updateUser(id, userInfo);
    }

    // DELETE API - Xóa người dùng (Admin)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        return userInfoService.deleteUser(id);
    }
}