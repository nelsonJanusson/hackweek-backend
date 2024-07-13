package com.example.hackweekbackend.assignment.service;

import com.example.hackweekbackend.assignment.model.Assignment;
import com.example.hackweekbackend.assignment.repository.AssignmentRepo;
import com.example.hackweekbackend.driver.repository.DriverRepo;
import com.example.hackweekbackend.driver.model.Driver;
import com.example.hackweekbackend.leg.Leg;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class AssignmentService {
    private final AssignmentRepo assignmentRepo;
    private final DriverRepo driverRepo;

    public Assignment createAssignment(Assignment assignment){
        return assignmentRepo.save(assignment);
    }

    public Assignment addLeg(Leg leg, UUID assignmentId){
        Assignment assignment = assignmentRepo.findById(assignmentId).get();
        assignment.getLegs().add(leg);
        return assignmentRepo.save(assignment);
    }

    public Assignment getAssignment(UUID assignmentId) {
        return assignmentRepo.findById(assignmentId).get();
    }

    public Assignment setDriver(UUID assignmentId, UUID driverId) {
        Assignment assignment = assignmentRepo.findById(assignmentId).get();
        Driver driver = driverRepo.findById(driverId).get();
        assignment.setDriver(driver);
        return assignmentRepo.save(assignment);
    }

    public Assignment update(Assignment assignment) {
        return assignmentRepo.save(assignment);
    }
}