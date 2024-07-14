package com.example.hackweekbackend.assignment.service;

import com.example.hackweekbackend.assignment.model.Assignment;
import com.example.hackweekbackend.leg.Leg;

import java.util.List;
import java.util.UUID;

public interface AssignmentService {

    Assignment createAssignment(Assignment assignment);

    Assignment addLeg(Leg leg, UUID assignmentId);

    Assignment getAssignment(UUID assignmentId);

    Assignment setDriver(UUID assignmentId, UUID driverId);

    Assignment update(Assignment assignment);

    List<Assignment> getAssignments();

    void deleteAssignment(UUID assignmentId);
}