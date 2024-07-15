package com.example.hackweekbackend.leg;

import java.time.LocalDate;

public record AddLegDto(
        LocalDate startDate,
        LocalDate endDate,
                        String startLocation,
                        String endLocation) {}