package com.tourism.Travel_Buddy.controller;

import ch.qos.logback.core.model.Model;
import com.tourism.Travel_Buddy.model.Packages;
import com.tourism.Travel_Buddy.services.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
public class PackageController {

    @Autowired
    private PackageService packageService;

    //-------------------------Add package---------------------------------------------
    @PostMapping(value = "/addPackage",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String addPackage(@ModelAttribute Packages pack,@RequestParam("file") MultipartFile file) throws IOException {
        packageService.addPackage(pack,file);
        return "Package added";
    }

    //--------------------------Get pack by id-------------------------------------------
    @GetMapping("/gatPackage/{id}")
    public ResponseEntity<Optional<Packages>> getUser(@PathVariable int id) {
        return ResponseEntity.ok(packageService.getPackage(id));
    }

    //------------------------update pack details---------------------------------------
//    @PutMapping("/user/update/{id}")
//    public User updateUser(@RequestBody User user,@PathVariable int id) {
//        return userService.updateUser(user,id);
//
//    }

    //-----------------------------Delete package-------------------------------------------
    @DeleteMapping("/deletePack/{id}")
    public ResponseEntity<String> deletePackage(@PathVariable int id) {
        packageService.deletePackage(id);
        return ResponseEntity.ok("Delete package successful");
    }

}
