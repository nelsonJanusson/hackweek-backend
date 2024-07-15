package com.example.hackweekbackend.customer.repository;

import com.example.hackweekbackend.customer.model.Customer;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface JpaCustomerRepo extends ListCrudRepository<Customer, UUID> {
}
