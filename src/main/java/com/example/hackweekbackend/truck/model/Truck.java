package com.example.hackweekbackend.truck.model;


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
@Table(name = "truck")
public class Truck {

    public Truck(AddTruckDto addTruckDto){
        year = addTruckDto.year();
        type = addTruckDto.type();
    }

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "type", nullable = false)
    private String type;

    public TruckDto mapToDto(){
        return new TruckDto(id, year, type);
    }


}