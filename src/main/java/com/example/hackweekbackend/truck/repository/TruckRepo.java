package com.example.hackweekbackend.truck.repository;

import com.example.hackweekbackend.driver.model.Status;
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

    public List<Truck> getUnassignedTrucks() {
        return jpaTruckRepo.findAllByStatus(Status.UNASSIGNED);
    }
    public List<Truck> getAssignedTrucks() {
        return jpaTruckRepo.findAllByStatus(Status.ASSIGNED);
    }

    public void deleteTruck(UUID truckId) {
        if (!jpaTruckRepo.existsById(truckId)) {
            throw new NoSuchElementException("no truck with matching id found");
        }
        jpaTruckRepo.deleteById(truckId);
    }

    public Truck assignTruck(UUID truckId) {
        Truck truck = jpaTruckRepo.findById(truckId)
                .orElseThrow(() -> new NoSuchElementException("no truck with matching id found"));
        truck.setStatus(Status.ASSIGNED);
        return jpaTruckRepo.save(truck);
    }
}
