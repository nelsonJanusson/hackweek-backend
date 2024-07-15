package com.example.hackweekbackend.truck.model;

import java.util.UUID;

public record TruckInfo(UUID id,
                        double payload,
                        double weight,
                        double height,
                        String status) {
}
