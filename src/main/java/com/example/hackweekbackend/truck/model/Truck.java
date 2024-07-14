package com.example.hackweekbackend.truck.model;


import com.example.hackweekbackend.assignment.model.Assignment;
import com.example.hackweekbackend.driver.model.Status;
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
@Table(name = "truck")
public class Truck {

    public Truck(AddTruckDto addTruckDto){
        year = addTruckDto.year();
        type = addTruckDto.type();
        status = Status.UNASSIGNED;
        assignments = new ArrayList<>();
    }

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "type", nullable = false)
    private String type;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "truck", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<Assignment> assignments;

    public TruckDto mapToDto(){
        return new TruckDto(id, year, type,status.status, assignments.stream().map(Assignment::mapToDto).toList());
    }
    public TruckInfo mapToInfo(){
        return new TruckInfo(id, year, type,status.status);
    }


}