package com.example.hackweekbackend.invoice;

import java.util.UUID;

public record InvoiceInfo (UUID id, double sum, boolean paid) {
}
