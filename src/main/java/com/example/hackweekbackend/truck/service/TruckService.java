package com.example.hackweekbackend.truck.service;

import com.example.hackweekbackend.truck.model.Truck;
import java.util.List;
import java.util.UUID;

public interface TruckService {

    Truck createTruck(Truck truck);

    Truck getTruck(UUID truckId);

    List<Truck> getTrucks();

    void deleteTruck(UUID truckId);
}
