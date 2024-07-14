package com.example.hackweekbackend.leg;

import com.example.hackweekbackend.assignment.model.Assignment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import java.time.LocalDateTime;
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
    private LocalDateTime startDate;

    @Column(name = "npmend_date", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "start_location", nullable = false)
    private String startLocation;

    @Column(name = "end_location", nullable = false)
    private String endLocation;

    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    public LegInfo mapToInfo(){
        return new LegInfo(id,startDate,endDate,startLocation,endLocation);
    }
}
