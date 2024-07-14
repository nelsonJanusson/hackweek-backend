package com.example.hackweekbackend.assignment.model;

import com.example.hackweekbackend.driver.model.DriverInfo;
import com.example.hackweekbackend.leg.Leg;
import com.example.hackweekbackend.truck.model.TruckDto;

import java.util.List;
import java.util.UUID;

public record AssignmentDto(UUID id,
                            List<Leg> legs,
                            String product,
                            String pickupLocation,
                            String destination,
                            DriverInfo driverInfo,
                            TruckDto truckDto,
                            String status) {}