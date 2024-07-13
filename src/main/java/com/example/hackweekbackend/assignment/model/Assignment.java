package com.example.hackweekbackend.assignment.model;

import com.example.hackweekbackend.driver.model.Driver;
import com.example.hackweekbackend.driver.model.DriverDto;
import com.example.hackweekbackend.leg.Leg;
import com.example.hackweekbackend.truck.model.Truck;
import com.example.hackweekbackend.truck.model.TruckDto;

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
@Table(name = "assignment")
public class Assignment {

    public Assignment (AddAssignmentDto addAssignmentDto){
        product=addAssignmentDto.product();
        pickupLocation = addAssignmentDto.pickupLocation();
        destination = addAssignmentDto.destination();
    }

    @Id
    @UuidGenerator
    private UUID id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Leg> legs = new ArrayList<>();

    @Column(name = "product", nullable = false)
    private String product;

    @Column(name = "pickup_location", nullable = false)
    private String pickupLocation;

    @Column(name = "destination", nullable = false)
    private String destination;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "truck_id")
    private Truck truck;

    public AssignmentDto mapToDto(){
        DriverDto driverDto = driver==null? null:driver.mapToDto();
        TruckDto truckDto = truck==null? null:truck.mapToDto();

        return new AssignmentDto(id,legs,product,pickupLocation,destination, driverDto, truckDto);
    }
}