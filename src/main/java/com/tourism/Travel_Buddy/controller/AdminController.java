package com.tourism.Travel_Buddy.controller;

import com.tourism.Travel_Buddy.model.Admin;
import com.tourism.Travel_Buddy.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admin/dashboard")
    public String welcome(){
        return "Welcome Admin";
    }

    @PostMapping("/reg")
    public String registerAdmin(@RequestBody Admin admin){
        adminService.registerAdmin(admin);
        return "add";
    }



}
