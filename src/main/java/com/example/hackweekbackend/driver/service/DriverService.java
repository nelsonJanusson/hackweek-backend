package com.example.hackweekbackend.driver.service;


import com.example.hackweekbackend.driver.model.Driver;
import com.example.hackweekbackend.driver.repository.DriverRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class DriverService {
    private final DriverRepo driverRepo;

    public Driver createDriver(Driver driver) {
        return driverRepo.save(driver);
    }

    public Driver getDriver(UUID driverId) {
        return driverRepo.findById(driverId).get();
    }

    public List<Driver> getDrivers() {
        return driverRepo.findAll();
    }
}