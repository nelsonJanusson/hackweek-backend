package com.example.hackweekbackend.truck.repository;


import com.example.hackweekbackend.truck.model.Truck;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface TruckRepo extends ListCrudRepository<Truck, UUID> {}