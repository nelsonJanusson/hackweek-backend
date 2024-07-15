package com.example.hackweekbackend.customer.model;

import com.example.hackweekbackend.invoice.AddInvoiceDto;
import com.example.hackweekbackend.invoice.InvoiceDto;
import com.example.hackweekbackend.invoice.InvoiceInfo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

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

    public CustomerDto mapToDto(){
        return new CustomerDto(id, name);
    }

    public CustomerInfo mapToInfo(){
        return new CustomerInfo(id, name);
    }
}
