package com.example.hackweekbackend.driver.service;


import com.example.hackweekbackend.assignment.model.Assignment;
import com.example.hackweekbackend.assignment.repository.AssignmentRepo;
import com.example.hackweekbackend.driver.model.Driver;
import com.example.hackweekbackend.driver.repository.DriverRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class DriverServiceImpl implements DriverService{
    private final DriverRepo driverRepo;
    private final AssignmentRepo assignmentRepo;

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
        Driver driver = driverRepo.getDriver(driverId);
        List<Assignment> assignments = driver.getAssignments();
        assignments.stream().peek(assignment -> assignment.setDriver(null)).forEach(assignmentRepo::updateAssignment);
        driver.setAssignments(new ArrayList<>());
        driverRepo.updateDriver(driver);
        driverRepo.deleteDriver(driverId);
    }

    @Override
    public List<Driver> getAssignedDrivers() {
        return driverRepo.getAssignedDrivers();
    }

    @Override
    public List<Driver> getUnassignedDrivers() {
        return driverRepo.getUnassignedDrivers();
    }
}