package com.tourism.Travel_Buddy.controller;

import com.tourism.Travel_Buddy.model.User;
import com.tourism.Travel_Buddy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //-------------------------Register user---------------------------------------------
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("Registration successful");
    }

    //--------------------------Get user by id-------------------------------------------
    @GetMapping("/user/getUser/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    //------------------------update user details---------------------------------------
    @PutMapping("/user/update/{id}")
    public User updateUser(@RequestBody User user,@PathVariable int id) {
        return userService.updateUser(user,id);

    }

    //-----------------------------Delete user-------------------------------------------
    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("Deleted successful");
    }

}
