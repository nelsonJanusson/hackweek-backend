package com.example.hackweekbackend.driver.model;

import java.util.UUID;

public record DriverInfo(UUID id,
                         String name,
                         double salary,
                         String status){}
