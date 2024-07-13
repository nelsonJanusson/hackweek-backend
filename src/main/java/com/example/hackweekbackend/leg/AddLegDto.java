package com.example.hackweekbackend.leg;

import java.time.LocalDateTime;
import java.util.UUID;

public record AddLegDto(UUID assignmentId,
                        LocalDateTime startDate,
                        LocalDateTime endDate,
                        String startLocation,
                        String endLocation) {}