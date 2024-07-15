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
        payload = addTruckDto.payload();
        weight = addTruckDto.weight();
        height = addTruckDto.height();
        status = Status.UNASSIGNED;
        assignments = new ArrayList<>();
    }

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "payload", nullable = false)
    private double payload;

    @Column(name = "weight", nullable = false)
    private double weight;

    @Column(name = "height", nullable = false)
    private double height;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "truck", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<Assignment> assignments;

    public TruckDto mapToDto(){
        return new TruckDto(id, payload, weight, height ,status.status, assignments.stream().map(Assignment::mapToDto).toList());
    }
    public TruckInfo mapToInfo(){
        return new TruckInfo(id, payload, weight, height ,status.status);
    }


}