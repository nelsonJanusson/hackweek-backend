package com.example.hackweekbackend.driver.repository;

import com.example.hackweekbackend.driver.model.Driver;
import com.example.hackweekbackend.driver.model.Status;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class DriverRepo {

    private final JpaDriverRepo jpaDriverRepo;

    public Driver createDriver(Driver driver) {
        return jpaDriverRepo.save(driver);
    }

    public Driver getDriver(UUID driverId) {
        return jpaDriverRepo.findById(driverId)
                .orElseThrow(() -> new NoSuchElementException("no driver with matching id found"));
    }

    public List<Driver> getDrivers() {
        return jpaDriverRepo.findAll();
    }

    public List<Driver> getUnassignedDrivers() {
        return jpaDriverRepo.findAllByStatus(Status.UNASSIGNED);
    }

    public List<Driver> getAssignedDrivers() {
        return jpaDriverRepo.findAllByStatus(Status.ASSIGNED);
    }

    public void deleteDriver(UUID driverId) {
        if (!jpaDriverRepo.existsById(driverId)) {
            throw new NoSuchElementException("no driver with matching id found");
        }
        jpaDriverRepo.deleteById(driverId);
    }

    public Driver assignDriver(UUID driverId) {
        Driver driver = jpaDriverRepo.findById(driverId)
                .orElseThrow(() -> new NoSuchElementException("no driver with matching id found"));
        driver.setStatus(Status.ASSIGNED);
        return jpaDriverRepo.save(driver);
    }
    public Driver updateDriver(Driver driver) {
        return jpaDriverRepo.save(driver);
    }
}
