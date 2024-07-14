package com.example.hackweekbackend.driver.repository;

import com.example.hackweekbackend.driver.model.Driver;
import com.example.hackweekbackend.driver.model.Status;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.UUID;

public interface JpaDriverRepo extends ListCrudRepository<Driver, UUID> {
    List<Driver> findAllByStatus(Status status);
}