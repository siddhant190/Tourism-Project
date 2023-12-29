package com.tourism.Travel_Buddy.repository;

import com.tourism.Travel_Buddy.model.Packages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PackageRepo extends JpaRepository<Packages,Integer> {

    @Override
    Optional<Packages> findById(Integer integer);
}
