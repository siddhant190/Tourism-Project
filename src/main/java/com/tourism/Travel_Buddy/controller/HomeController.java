package com.tourism.Travel_Buddy.controller;

import ch.qos.logback.core.model.Model;
import com.tourism.Travel_Buddy.model.User;
import com.tourism.Travel_Buddy.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/login")
   public String login(@RequestBody User user){
        homeService.login(user);
        return "login successful";
    }


}
