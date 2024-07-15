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
        assignments = new ArrayList<>();
        status = Status.UNASSIGNED;
    }

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "driver", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<Assignment> assignments;

    @Enumerated(EnumType.STRING)
    private Status status;

    public DriverDto mapToDto(){
        return new DriverDto(id,name,assignments.stream().map(Assignment::mapToDto).toList(),status.status);
    }

    public DriverInfo mapToInfo(){
        return new DriverInfo(id,name,status.status);
    }
}