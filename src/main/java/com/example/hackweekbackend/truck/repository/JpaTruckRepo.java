package com.example.hackweekbackend.truck.repository;

import com.example.hackweekbackend.driver.model.Status;
import com.example.hackweekbackend.truck.model.Truck;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.UUID;

public interface JpaTruckRepo extends ListCrudRepository<Truck, UUID> {
    List<Truck> findAllByStatus(Status status);
}