package com.example.hackweekbackend.assignment.service;

import com.example.hackweekbackend.assignment.model.Assignment;
import com.example.hackweekbackend.assignment.model.AssignmentStatus;
import com.example.hackweekbackend.assignment.repository.AssignmentRepo;
import com.example.hackweekbackend.driver.model.Status;
import com.example.hackweekbackend.driver.repository.DriverRepo;
import com.example.hackweekbackend.leg.Leg;
import com.example.hackweekbackend.truck.repository.TruckRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentRepo assignmentRepo;
    private final DriverRepo driverRepo;
    private final TruckRepo truckRepo;

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
    public List<Assignment> getAssignments() {
        return assignmentRepo.getAssignments();
    }

    @Override
    public void deleteAssignment(UUID assignmentId) {
        assignmentRepo.deleteAssignment(assignmentId);
    }

    @Override
    public Assignment assignAssignment(UUID assignmentId, UUID truckId, UUID driverId) {
        Assignment assignment = assignmentRepo.getAssignment(assignmentId);
        assignment.setDriver(driverRepo.assignDriver(driverId));
        assignment.setTruck(truckRepo.assignTruck(truckId));
        assignment.setStatus(AssignmentStatus.ACTIVE);
        return assignmentRepo.updateAssignment(assignment);
    }

    @Override
    public Assignment finnishAssignment(UUID assignmentId) {
        Assignment assignment = assignmentRepo.getAssignment(assignmentId);
        assignment.setStatus(AssignmentStatus.FINISHED);
        assignment.getDriver().setStatus(Status.UNASSIGNED);
        assignment.getTruck().setStatus(Status.UNASSIGNED);
        return assignmentRepo.updateAssignment(assignment);
    }
}