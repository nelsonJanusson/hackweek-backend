package com.example.hackweekbackend.truck.model;

import java.util.UUID;

public record TruckDto(UUID id, int year, String type) {}