package com.example.hackweekbackend.customer.repository;

import com.example.hackweekbackend.customer.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class CustomerRepo {
    private final JpaCustomerRepo jpaCustomerRepo;

    public List<Customer> getCustomers() {
        return jpaCustomerRepo.findAll();
    }

    public Customer getCustomer(UUID customerId) {
        return jpaCustomerRepo.findById(customerId)
                .orElseThrow(() -> new NoSuchElementException("no customer with matching id found"));
    }

    public Customer createCustomer(Customer customer) {
        return jpaCustomerRepo.save(customer);

    }

    public void deleteCustomer(UUID customerId) {
        if (!jpaCustomerRepo.existsById(customerId)) {
            throw new NoSuchElementException("no customer with matching id found");
        }
        jpaCustomerRepo.deleteById(customerId);
    }
}
