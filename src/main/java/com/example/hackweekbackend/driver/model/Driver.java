package com.example.hackweekbackend.driver.model;

import jakarta.persistence.*;
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
@Table(name = "driver")
public class Driver {

    public Driver(AddDriverDto addDriverDto){
        name = addDriverDto.name();
        salary = addDriverDto.salary();
    }
    public Driver(DriverDto driverDto){
        id = driverDto.id();
        name = driverDto.name();
        salary = driverDto.salary();
    }

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "salary", nullable = false)
    private double salary;

    public DriverDto mapToDto(){
        return new DriverDto(id,name,salary);
    }
}