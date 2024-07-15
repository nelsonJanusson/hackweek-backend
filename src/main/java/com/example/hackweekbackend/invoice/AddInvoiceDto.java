package com.example.hackweekbackend.invoice;

import java.util.UUID;

public record AddInvoiceDto(double sum, boolean paid) {
}
