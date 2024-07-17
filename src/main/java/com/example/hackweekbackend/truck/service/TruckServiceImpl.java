package com.example.hackweekbackend.truck.service;


import com.example.hackweekbackend.assignment.model.Assignment;
import com.example.hackweekbackend.assignment.repository.AssignmentRepo;
import com.example.hackweekbackend.driver.model.Driver;
import com.example.hackweekbackend.truck.model.Truck;
import com.example.hackweekbackend.truck.repository.TruckRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class TruckServiceImpl implements TruckService {
    private final TruckRepo truckRepo;
    private final AssignmentRepo assignmentRepo;

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
        Truck truck = truckRepo.getTruck(truckId);
        List<Assignment> assignments = truck.getAssignments();
        assignments.stream().peek(assignment -> assignment.setDriver(null)).forEach(assignmentRepo::updateAssignment);
        truck.setAssignments(new ArrayList<>());
        truckRepo.updateTruck(truck);
        truckRepo.deleteTruck(truckId);
    }

    @Override
    public List<Truck> getAssignedTrucks() {
        return truckRepo.getAssignedTrucks();
    }

    @Override
    public List<Truck> getUnassignedTrucks() {
        return truckRepo.getUnassignedTrucks();
    }

}