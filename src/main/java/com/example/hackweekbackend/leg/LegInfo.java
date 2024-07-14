package com.example.hackweekbackend.leg;

import java.time.LocalDateTime;
import java.util.UUID;

public record LegInfo(
        UUID id,
        LocalDateTime startDate,
        LocalDateTime endDate,
        String startLocation,
        String endLocation) {}
