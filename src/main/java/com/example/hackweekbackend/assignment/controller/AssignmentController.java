package com.example.hackweekbackend.assignment.controller;

import com.example.hackweekbackend.leg.AddLegDto;
import com.example.hackweekbackend.leg.Leg;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.hackweekbackend.assignment.service.AssignmentService;
import com.example.hackweekbackend.assignment.model.AssignmentDto;
import com.example.hackweekbackend.assignment.model.AddAssignmentDto;
import com.example.hackweekbackend.assignment.model.Assignment;

import java.util.UUID;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/api/assignment")
public class AssignmentController {
    private final AssignmentService assignmentService;

    @PostMapping
    ResponseEntity<AssignmentDto> createAssignment(@RequestBody AddAssignmentDto addAssignmentDto) {
        AssignmentDto assignmentDto = assignmentService.createAssignment(new Assignment(addAssignmentDto)).mapToDto();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("location", "/api/assignment/" + assignmentDto.id())
                .body(assignmentDto);
    }

    @PostMapping("/{assignmentId}/{driverId}")
    ResponseEntity<AssignmentDto> setDriver(@PathVariable UUID assignmentId,@PathVariable UUID driverId) {
        AssignmentDto assignmentDto = assignmentService.setDriver(assignmentId,driverId).mapToDto();
        return ResponseEntity
                .accepted()
                .body(assignmentDto);
    }
    @PutMapping
    ResponseEntity<AssignmentDto> updateAssignment(@RequestBody AddAssignmentDto addAssignmentDto) {
        AssignmentDto assignmentDto = assignmentService.update(new Assignment(addAssignmentDto)).mapToDto();
        return ResponseEntity
                .accepted()
                .body(assignmentDto);
    }

    @PostMapping("/leg")
    ResponseEntity<AssignmentDto> addLeg(@RequestBody AddLegDto addLegDto) {
        return ResponseEntity
                .accepted()
                .body(assignmentService
                        .addLeg(new Leg(addLegDto), addLegDto.assignmentId())
                        .mapToDto());
    }

    @GetMapping("/{assignmentId}")
    ResponseEntity<AssignmentDto> getAssignment(@PathVariable UUID assignmentId) {
        return ResponseEntity.ok(assignmentService.getAssignment(assignmentId).mapToDto());
    }
}