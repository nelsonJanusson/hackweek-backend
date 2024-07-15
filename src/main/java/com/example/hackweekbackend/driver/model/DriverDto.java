package com.example.hackweekbackend.driver.model;

import com.example.hackweekbackend.assignment.model.AssignmentDto;

import java.util.List;
import java.util.UUID;

public record DriverDto(UUID id,
                        String name,
                        List<AssignmentDto> assignments,
                        String status) {}