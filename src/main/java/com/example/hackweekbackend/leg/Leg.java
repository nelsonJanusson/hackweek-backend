package com.example.hackweekbackend.leg;

import com.example.hackweekbackend.assignment.model.Assignment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "leg")
public class Leg {

    public Leg(AddLegDto addLegDto){
        startDate=addLegDto.startDate();
        endDate=addLegDto.endDate();
        startLocation=addLegDto.startLocation();
        endLocation=addLegDto.endLocation();

    }

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "start_location", nullable = false)
    private String startLocation;

    @Column(name = "end_location", nullable = false)
    private String endLocation;

    @ManyToOne(optional = false)
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    public LegInfo mapToInfo(){
        return new LegInfo(id,startDate,endDate,startLocation,endLocation);
    }
}
