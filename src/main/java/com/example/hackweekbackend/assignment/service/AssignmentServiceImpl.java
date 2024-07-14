package com.example.hackweekbackend.assignment.service;

import com.example.hackweekbackend.assignment.model.Assignment;
import com.example.hackweekbackend.assignment.repository.AssignmentRepo;
import com.example.hackweekbackend.driver.repository.JpaDriverRepo;
import com.example.hackweekbackend.driver.model.Driver;
import com.example.hackweekbackend.leg.Leg;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentRepo assignmentRepo;
    private final JpaDriverRepo driverRepo;

    @Override
    public Assignment createAssignment(Assignment assignment){
        return assignmentRepo.createAssignment(assignment);
    }

    @Override
    public Assignment addLeg(Leg leg, UUID assignmentId){
        Assignment assignment = assignmentRepo.getAssignment(assignmentId);
        assignment.getLegs().add(leg);
        return assignmentRepo.updateAssignment(assignment);
    }

    @Override
    public Assignment getAssignment(UUID assignmentId) {
        return assignmentRepo.getAssignment(assignmentId);
    }

    @Override
    public Assignment setDriver(UUID assignmentId, UUID driverId) {
        Assignment assignment = assignmentRepo.getAssignment(assignmentId);
        Driver driver = driverRepo.findById(driverId).get();
        assignment.setDriver(driver);
        return assignmentRepo.updateAssignment(assignment);
    }

    @Override
    public Assignment update(Assignment assignment) {
        return assignmentRepo.updateAssignment(assignment);
    }

    @Override
    public List<Assignment> getAssignments() {
        return assignmentRepo.getAssignments();
    }

    @Override
    public void deleteAssignment(UUID assignmentId) {
        assignmentRepo.deleteAssignment(assignmentId);
    }
}