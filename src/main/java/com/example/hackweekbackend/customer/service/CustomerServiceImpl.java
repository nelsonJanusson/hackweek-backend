package com.example.hackweekbackend.customer.service;

import com.example.hackweekbackend.assignment.model.Assignment;
import com.example.hackweekbackend.assignment.repository.AssignmentRepo;
import com.example.hackweekbackend.customer.model.Customer;
import com.example.hackweekbackend.customer.repository.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepo customerRepo;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepo.createCustomer(customer);
    }

    @Override
    public Customer getCustomer(UUID customerId) {
        return customerRepo.getCustomer(customerId);
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepo.getCustomers();
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        customerRepo.deleteCustomer(customerId);
    }

    @Override
    public Customer addAssignment(Assignment assignment, UUID customerId) {
        Customer customer = customerRepo.getCustomer(customerId);
        assignment.setCustomer(customer);
        customer.getAssignments().add(assignment);
        return customerRepo.updateCustomer(customer);
    }
}
