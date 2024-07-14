package com.example.hackweekbackend.driver.model;

import com.example.hackweekbackend.assignment.model.AssignmentInfo;

import java.util.List;
import java.util.UUID;

public record DriverDto(UUID id,
                        String name,
                        double salary,
                         List<AssignmentInfo> assignments) {}