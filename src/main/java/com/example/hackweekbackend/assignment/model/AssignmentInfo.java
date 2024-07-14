package com.example.hackweekbackend.assignment.model;

import com.example.hackweekbackend.leg.Leg;
import com.example.hackweekbackend.truck.model.TruckDto;

import java.util.List;
import java.util.UUID;

public record AssignmentInfo(UUID id,
                             List<Leg> legs,
                             String product,
                             String pickupLocation,
                             String destination,
                             TruckDto truckDto,
                             String status) {}
