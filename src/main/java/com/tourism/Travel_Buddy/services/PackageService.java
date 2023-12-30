package com.tourism.Travel_Buddy.services;

import com.tourism.Travel_Buddy.model.Packages;
import com.tourism.Travel_Buddy.repository.PackageRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PackageService {

    @Autowired
    private PackageRepo packageRepo;
    public void deletePackage(int id) {
        packageRepo.deleteById(id);
    }

    public Optional<Packages> getPackage(int id) {
        return packageRepo.findById(id);
    }

    public String addPackage(Packages pack,MultipartFile file) throws IOException {
        if (file.isEmpty()) {

            pack.setImg("contact.png");

        } else {
            pack.setImg(file.getOriginalFilename());

            File saveFile = new ClassPathResource("static/image").getFile();

            Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());

            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        }

        //pack.setImg(file.getBytes());
        packageRepo.save(pack);
        return "Package add";

    }

    public List<Packages> getAllPackages() {
        System.out.println("packages send");
        return packageRepo.findAll();
    }
}
