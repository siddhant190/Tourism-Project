package com.tourism.Travel_Buddy.repository;

import com.tourism.Travel_Buddy.model.PackageBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<PackageBooking, Integer> {
    
}