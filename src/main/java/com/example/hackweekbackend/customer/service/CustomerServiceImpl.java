package com.example.hackweekbackend.customer.service;

import com.example.hackweekbackend.customer.repository.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepo customerRepo;
}
