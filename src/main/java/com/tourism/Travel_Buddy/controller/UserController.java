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

//    //-------------------------Register user---------------------------------------------
//    @PostMapping("/register")
//    public User registerUser(@RequestBody User user) {
//        //userService.registerUser(user);
//        return userService.registerUser(user);
//    }

    //--------------------------Get user by id-------------------------------------------
//    @GetMapping("/user/getUser/{id}")
//    public ResponseEntity<User> getUser(@RequestParam("id") int id) {
//        return ResponseEntity.ok(userService.getUser(id));
//    }

    @GetMapping("/user/getUser/email/{email}")
    public ResponseEntity<User> getUserByEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }
    @GetMapping("/user")
    public String welcomeUser() {
        System.out.println("welcome");
        return "Welcome";
    }

    //------------------------update user details---------------------------------------
//    @PutMapping("/user/update/{id}")
//    public User updateUser(@RequestBody User user,@RequestParam("id") int id) {
//        return userService.updateUser(user,id);
//
//    }

    //-----------------------------Delete user-------------------------------------------
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> deleteUser(@RequestParam("id") int id) {
//        userService.deleteUser(id);
//        return ResponseEntity.ok("Deleted successful");
//    }

}
