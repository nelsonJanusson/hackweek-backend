package com.example.hackweekbackend.invoice;

import java.util.UUID;

public record InvoiceDto(UUID id, double sum, boolean paid) {
}
