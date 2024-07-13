package com.example.hackweekbackend.driver.model;

import java.util.UUID;

public record DriverDto(UUID id,
                        String name,
                        double salary) {}