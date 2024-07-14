package com.example.hackweekbackend.leg;

import java.time.LocalDateTime;

public record AddLegDto(
                        LocalDateTime startDate,
                        LocalDateTime endDate,
                        String startLocation,
                        String endLocation) {}