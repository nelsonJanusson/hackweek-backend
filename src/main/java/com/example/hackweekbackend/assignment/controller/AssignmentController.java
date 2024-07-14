package com.example.hackweekbackend.assignment.controller;

import com.example.hackweekbackend.assignment.service.AssignmentService;
import com.example.hackweekbackend.leg.AddLegDto;
import com.example.hackweekbackend.leg.Leg;
import com.example.hackweekbackend.truck.model.TruckDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.hackweekbackend.assignment.model.AssignmentDto;
import com.example.hackweekbackend.assignment.model.AddAssignmentDto;
import com.example.hackweekbackend.assignment.model.Assignment;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/assignment")
public class AssignmentController {
    private final AssignmentService assignmentService;
    private final URI uri;

    @PostMapping
    ResponseEntity<AssignmentDto> createAssignment(@RequestBody AddAssignmentDto addAssignmentDto) {
        AssignmentDto assignmentDto = assignmentService.createAssignment(new Assignment(addAssignmentDto)).mapToDto();
        return ResponseEntity
                .created(uri.resolve("/assignment/" + assignmentDto.id()))
                .body(assignmentDto);
    }

    @PostMapping("/{assignmentId}/{driverId}")
    ResponseEntity<AssignmentDto> setDriver(@PathVariable UUID assignmentId,@PathVariable UUID driverId) {
        return ResponseEntity
                .ok(assignmentService.setDriver(assignmentId,driverId).mapToDto());
    }
/*
    @PutMapping
    ResponseEntity<AssignmentDto> updateAssignment(@RequestBody AssignmentDto assignmentDto) {
        return ResponseEntity
                .ok(assignmentService.update(new Assignment(assignmentDto)).mapToDto());
    }

 */

    @PostMapping("/leg")
    ResponseEntity<AssignmentDto> addLeg(@RequestBody AddLegDto addLegDto) {
        return ResponseEntity
                .ok(assignmentService
                        .addLeg(new Leg(addLegDto), addLegDto.assignmentId())
                        .mapToDto());
    }

    @GetMapping("/{assignmentId}")
    ResponseEntity<AssignmentDto> getAssignment(@PathVariable UUID assignmentId) {
        return ResponseEntity.ok(assignmentService.getAssignment(assignmentId).mapToDto());
    }
    @GetMapping
    ResponseEntity<List<AssignmentDto>> getAssignments() {
        return ResponseEntity.ok(assignmentService.getAssignments().stream().map(Assignment::mapToDto).toList());
    }
    @DeleteMapping("/{assignmentId}")
    ResponseEntity<?> deleteAssignment(@PathVariable UUID assignmentId) {
        assignmentService.deleteAssignment(assignmentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/assign/{assignmentId}/{truckId}/{driverId}/")
    public ResponseEntity<AssignmentDto> assignAssignment(@PathVariable UUID assignmentId,
                                                          @PathVariable UUID truckId,
                                                          @PathVariable UUID driverId) {
        return ResponseEntity
                .ok(assignmentService.assignAssignment(assignmentId,truckId,driverId).mapToDto());
    }
    @PostMapping("/assign/{assignmentId}")
    public ResponseEntity<AssignmentDto> finnishAssignment(@PathVariable UUID assignmentId) {
        return ResponseEntity
                .ok(assignmentService.finnishAssignment(assignmentId).mapToDto());
    }

}