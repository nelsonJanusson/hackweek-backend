package com.example.hackweekbackend.customer.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CustomerRepo {
    private final JpaCustomerRepo jpaCustomerRepo;
}
