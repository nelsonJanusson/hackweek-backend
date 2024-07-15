package com.example.hackweekbackend.leg;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record LegInfo(
        UUID id,
        LocalDate startDate,
        LocalDate endDate,
        String startLocation,
        String endLocation) {}
