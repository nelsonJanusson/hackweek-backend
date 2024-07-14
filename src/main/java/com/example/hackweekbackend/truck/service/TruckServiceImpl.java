package com.example.hackweekbackend.truck.service;


import com.example.hackweekbackend.truck.model.Truck;
import com.example.hackweekbackend.truck.repository.TruckRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class TruckServiceImpl implements TruckService {
    private final TruckRepo truckRepo;

    @Override
    public Truck createTruck(Truck truck){
        return truckRepo.createTruck(truck);
    }

    @Override
    public Truck getTruck(UUID truckId) {
        return truckRepo.getTruck(truckId);
    }

    @Override
    public List<Truck> getTrucks() {
        return truckRepo.getTrucks();
    }

    @Override
    public void deleteTruck(UUID truckId) {
        truckRepo.deleteTruck(truckId);
    }
}