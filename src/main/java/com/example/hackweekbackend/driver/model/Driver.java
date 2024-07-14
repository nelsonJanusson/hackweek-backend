package com.example.hackweekbackend.driver.model;

import com.example.hackweekbackend.assignment.model.Assignment;
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
@Table(name = "driver")
public class Driver {

    public Driver(AddDriverDto addDriverDto){
        name = addDriverDto.name();
        salary = addDriverDto.salary();
        assignments = new ArrayList<>();
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

    @OneToMany(mappedBy = "driver", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<Assignment> assignments;

    public DriverDto mapToDto(){
        return new DriverDto(id,name,salary,assignments.stream().map(Assignment::mapToInfo).toList());
    }
    public DriverInfo mapToInfo(){
        return new DriverInfo(id,name,salary);
    }
}