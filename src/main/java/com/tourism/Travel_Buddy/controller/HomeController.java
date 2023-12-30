package com.tourism.Travel_Buddy.controller;

import ch.qos.logback.core.model.Model;
import com.tourism.Travel_Buddy.model.Status;
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

    @CrossOrigin
    @PostMapping("/loginAccount")
   public Status login(@RequestBody User user){
        return homeService.login(user);
    }

}
