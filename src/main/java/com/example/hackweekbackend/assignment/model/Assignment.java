package com.example.hackweekbackend.assignment.model;

import com.example.hackweekbackend.driver.model.Driver;
import com.example.hackweekbackend.driver.model.DriverInfo;
import com.example.hackweekbackend.leg.Leg;
import com.example.hackweekbackend.truck.model.Truck;
import com.example.hackweekbackend.truck.model.TruckDto;
import com.example.hackweekbackend.leg.LegInfo;

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
        status = AssignmentStatus.UNASSIGNED;
    }

    @Id
    @UuidGenerator
    private UUID id;

    @OneToMany(mappedBy = "assignment", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<Leg> legs = new ArrayList<>();

    @Column(name = "product", nullable = false)
    private String product;

    @Column(name = "pickup_location", nullable = false)
    private String pickupLocation;

    @Column(name = "destination", nullable = false)
    private String destination;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "truck_id")
    private Truck truck;

    @Enumerated(EnumType.STRING)
    private AssignmentStatus status;

    public AssignmentInfo mapToInfo(){
        TruckDto truckDto = truck==null? null:truck.mapToDto();
        return new AssignmentInfo(id,legs.stream().map(Leg::mapToInfo).toList(),product,pickupLocation,destination, truckDto,status.status);
    }

    public AssignmentDto mapToDto(){
        DriverInfo driverInfo = driver==null? null:driver.mapToInfo();
        TruckDto truckDto = truck==null? null:truck.mapToDto();
        return new AssignmentDto(id,legs.stream().map(Leg::mapToInfo).toList(),product,pickupLocation,destination, driverInfo, truckDto,status.status);
    }
}