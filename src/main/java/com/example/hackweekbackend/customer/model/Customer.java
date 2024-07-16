package com.example.hackweekbackend.customer.model;

import com.example.hackweekbackend.assignment.model.Assignment;
import com.example.hackweekbackend.invoice.AddInvoiceDto;
import com.example.hackweekbackend.invoice.InvoiceDto;
import com.example.hackweekbackend.invoice.InvoiceInfo;
import com.example.hackweekbackend.leg.Leg;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {

    public Customer(AddCustomerDto addCustomerDto){
        name = addCustomerDto.name();
    }

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "customer", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<Assignment> assignments = new ArrayList<>();

    public CustomerDto mapToDto(){
        return new CustomerDto(id, name,assignments.stream().map(Assignment::mapToDto).toList());
    }

    public CustomerInfo mapToInfo(){
        return new CustomerInfo(id, name);
    }
}
