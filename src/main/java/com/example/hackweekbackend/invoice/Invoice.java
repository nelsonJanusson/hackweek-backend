package com.example.hackweekbackend.invoice;

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
@Table(name = "invoice")
public class Invoice {

    public Invoice(AddInvoiceDto addInvoiceDto){
        sum = addInvoiceDto.sum();
    }

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "sum", nullable = false)
    private double sum;

    @Column(name = "paid", nullable = false)
    private boolean paid = false;

    public InvoiceDto mapToDto(){
        return new InvoiceDto(id, sum, paid);
    }

    public InvoiceInfo mapToInfo(){
        return new InvoiceInfo(id, sum, paid);
    }
}
