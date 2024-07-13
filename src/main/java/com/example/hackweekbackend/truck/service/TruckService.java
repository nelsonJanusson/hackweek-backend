package com.example.hackweekbackend.truck.service;


import com.example.hackweekbackend.truck.model.Truck;
import com.example.hackweekbackend.truck.repository.TruckRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class TruckService {
    private final TruckRepo truckRepo;

    public Truck createTruck(Truck truck){
        return truckRepo.save(truck);
    }

    public Truck getTruck(UUID truckId) {
        return truckRepo.findById(truckId).get();
    }

    public List<Truck> getTrucks() {
        return truckRepo.findAll();
    }
}