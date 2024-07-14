package com.example.hackweekbackend.truck.repository;

import com.example.hackweekbackend.assignment.model.Assignment;
import com.example.hackweekbackend.truck.model.Truck;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class TruckRepo {
    private final JpaTruckRepo jpaTruckRepo;

    public Truck createTruck(Truck truck){
        return jpaTruckRepo.save(truck);
    }

    public Truck getTruck(UUID truckId) {
        return jpaTruckRepo.findById(truckId)
                .orElseThrow(() -> new NoSuchElementException("no truck with matching id found"));
    }

    public List<Truck> getTrucks() {
        return jpaTruckRepo.findAll();
    }

    public Truck updateTruck(Truck truck) {
        if (truck.getId()==null||!jpaTruckRepo.existsById(truck.getId())) {
            throw new NoSuchElementException("no truck with matching id found");
        }
        return jpaTruckRepo.save(truck);
    }

    public void deleteTruck(UUID truckId) {
        if (!jpaTruckRepo.existsById(truckId)) {
            throw new NoSuchElementException("no truck with matching id found");
        }
        jpaTruckRepo.deleteById(truckId);
    }
}
