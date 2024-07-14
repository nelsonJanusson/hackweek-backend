package com.example.hackweekbackend.driver.service;

import com.example.hackweekbackend.driver.model.Driver;
import java.util.List;
import java.util.UUID;

public interface DriverService {
    Driver createDriver(Driver driver);
    Driver getDriver(UUID driverId);
    List<Driver> getDrivers();
    void deleteDriver(UUID driverId);
    List<Driver> getAssignedDrivers();
    List<Driver> getUnassignedDrivers();

}
