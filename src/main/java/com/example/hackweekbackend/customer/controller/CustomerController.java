package com.example.hackweekbackend.customer.controller;

import com.example.hackweekbackend.assignment.model.AddAssignmentDto;
import com.example.hackweekbackend.assignment.model.Assignment;
import com.example.hackweekbackend.customer.model.AddCustomerDto;
import com.example.hackweekbackend.customer.model.Customer;
import com.example.hackweekbackend.customer.model.CustomerDto;
import com.example.hackweekbackend.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final URI uri;


    @PostMapping
    ResponseEntity<CustomerDto> createCustomer(@RequestBody AddCustomerDto addCustomerDto) {
        CustomerDto customerDto = customerService.createCustomer(new Customer(addCustomerDto)).mapToDto();
        return ResponseEntity
                .created(uri.resolve("/customer/" + customerDto.id()))
                .body(customerDto);
    }

    @GetMapping("/{customerId}")
    ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId) {
        return ResponseEntity.ok(customerService.getCustomer(customerId).mapToDto());
    }
    @GetMapping
    ResponseEntity<List<CustomerDto>> getAssignments() {
        return ResponseEntity.ok(customerService.getCustomers().stream().map(Customer::mapToDto).toList());
    }
    @DeleteMapping("/{customerId}")
    ResponseEntity<?> deleteAssignment(@PathVariable UUID customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/{customerId}/assignment")
    ResponseEntity<CustomerDto> addLeg(@PathVariable UUID customerId, @RequestBody AddAssignmentDto addAssignmentDto) {
        return ResponseEntity
                .ok(customerService
                        .addAssignment(new Assignment(addAssignmentDto), customerId)
                        .mapToDto());
    }


}
