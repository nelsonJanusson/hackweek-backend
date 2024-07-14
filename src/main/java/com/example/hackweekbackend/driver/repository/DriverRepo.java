package com.example.hackweekbackend.driver.repository;

import com.example.hackweekbackend.driver.model.Driver;
import com.example.hackweekbackend.truck.model.Truck;
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
    public Driver updateDriver(Driver driver) {
        if (driver.getId()==null||!jpaDriverRepo.existsById(driver.getId())) {
            throw new NoSuchElementException("no driver with matching id found");
        }
        return jpaDriverRepo.save(driver);
    }

    public void deleteDriver(UUID driverId) {
        if (!jpaDriverRepo.existsById(driverId)) {
            throw new NoSuchElementException("no driver with matching id found");
        }
        jpaDriverRepo.deleteById(driverId);
    }
}
