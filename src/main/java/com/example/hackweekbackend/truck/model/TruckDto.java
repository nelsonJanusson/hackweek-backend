package com.example.hackweekbackend.truck.model;

import com.example.hackweekbackend.assignment.model.AssignmentDto;
import java.util.List;
import java.util.UUID;

public record TruckDto(UUID id, int year, String type, String status, List<AssignmentDto> assignments) {}