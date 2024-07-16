package com.example.hackweekbackend.assignment.model;

import com.example.hackweekbackend.customer.model.CustomerInfo;
import com.example.hackweekbackend.driver.model.DriverInfo;
import com.example.hackweekbackend.leg.LegInfo;
import com.example.hackweekbackend.truck.model.TruckInfo;

import java.util.List;
import java.util.UUID;

public record AssignmentDto(UUID id,
                            List<LegInfo> legs,
                            String product,
                            String pickupLocation,
                            String destination,
                            DriverInfo driverInfo,
                            TruckInfo truckInfo,
                            String status,
                            CustomerInfo customerInfo) {}