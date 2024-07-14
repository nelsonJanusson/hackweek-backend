package com.example.hackweekbackend.driver.service;


import com.example.hackweekbackend.driver.model.Driver;
import com.example.hackweekbackend.driver.repository.DriverRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class DriverServiceImpl implements DriverService{
    private final DriverRepo driverRepo;

    @Override
    public Driver createDriver(Driver driver) {
        return driverRepo.createDriver(driver);
    }


    @Override
    public Driver getDriver(UUID driverId) {
        return driverRepo.getDriver(driverId);
    }

    @Override
    public List<Driver> getDrivers() {
        return driverRepo.getDrivers();
    }

    @Override
    public void deleteDriver(UUID driverId) {
        driverRepo.deleteDriver(driverId);
    }

    @Override
    public Driver updateDriver(Driver driver) {
       return driverRepo.updateDriver(driver);
    }
}