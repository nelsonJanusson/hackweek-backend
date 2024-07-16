package com.example.hackweekbackend.customer.model;

import com.example.hackweekbackend.assignment.model.Assignment;
import com.example.hackweekbackend.assignment.model.AssignmentDto;

import java.util.List;
import java.util.UUID;

public record CustomerDto(UUID id,
                          String name,
                          List<AssignmentDto> assignments) {
}
