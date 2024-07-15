package com.example.hackweekbackend.customer.service;

import com.example.hackweekbackend.customer.model.Customer;
import com.example.hackweekbackend.customer.model.CustomerDto;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public interface CustomerService {
    Customer createCustomer(Customer customer);

    Customer getCustomer(UUID customerId);

    List<Customer> getCustomers();

    void deleteCustomer(UUID customerId);
}
