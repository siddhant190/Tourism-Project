package com.tourism.Travel_Buddy.controller;

import com.tourism.Travel_Buddy.model.Packages;
import com.tourism.Travel_Buddy.services.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class PackageController {

    @Autowired
    private PackageService packageService;

    //-------------------------Add package---------------------------------------------

    @PostMapping(value = "/addPackage")
    public ResponseEntity<Packages> addPackage(@RequestBody Packages pack) throws IOException {
        System.out.println("Received Package: " + pack);
        return ResponseEntity.ok(packageService.addPackage(pack));
    }

    //--------------------------Get pack by id-------------------------------------------
    @GetMapping("/getPackage/{id}")
    public ResponseEntity<Optional<Packages>> getPackage(@PathVariable int id) {
        return ResponseEntity.ok(packageService.getPackage(id));
    }

    @GetMapping("/getAllPackage")
    public ResponseEntity<List<Packages>> getAllPackages() {
        return ResponseEntity.ok(packageService.getAllPackages());
    }

    //------------------------update pack details---------------------------------------
    @PutMapping("/updatePackages/{id}")
    public Packages updatePackage(@RequestBody Packages pack,@PathVariable int id) {
        return packageService.updatePackage(pack,id);
    }

    //-----------------------------Delete package-------------------------------------------
    @DeleteMapping("/deletePack/{id}")
    public ResponseEntity<String> deletePackage(@PathVariable int id) {
        packageService.deletePackage(id);
        return ResponseEntity.ok("Delete package successful");
    }

}
