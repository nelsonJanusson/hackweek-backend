package com.example.hackweekbackend.truck.model;

import java.util.UUID;

public record TruckInfo(UUID id, int year, String type, String status) {
}
