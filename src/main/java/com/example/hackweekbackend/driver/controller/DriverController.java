package com.example.hackweekbackend.driver.controller;

import com.example.hackweekbackend.driver.model.AddDriverDto;
import com.example.hackweekbackend.driver.model.Driver;
import com.example.hackweekbackend.driver.model.DriverDto;
import com.example.hackweekbackend.driver.service.DriverService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/driver")
public class DriverController {
    private final DriverService driverService;
    private final URI uri;

    @PostMapping
    ResponseEntity<DriverDto> createDriver(@RequestBody AddDriverDto addDriverDto) {
        DriverDto driverDto = driverService.createDriver(new Driver(addDriverDto)).mapToDto();
        return ResponseEntity
                .created(uri.resolve("/driver/" + driverDto.id()))
                .body(driverDto);
    }
    @GetMapping("/{driverId}")
    ResponseEntity<DriverDto> getDriver(@PathVariable UUID driverId) {
        return ResponseEntity.ok(driverService.getDriver(driverId).mapToDto());
    }
    @GetMapping
    ResponseEntity<List<DriverDto>> getDrivers() {
        return ResponseEntity.ok(driverService.getDrivers().stream().map(Driver::mapToDto).toList());
    }

    @DeleteMapping("/{driverId}")
    ResponseEntity<?> deleteDriver(@PathVariable UUID driverId) {
       driverService.deleteDriver(driverId);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/unassigned")
    ResponseEntity<List<DriverDto>> getUnassignedTrucks() {
        return ResponseEntity.ok(driverService.getUnassignedDrivers().stream().map(Driver::mapToDto).toList());
    }

    @GetMapping("/assigned")
    ResponseEntity<List<DriverDto>> getAssignedTrucks() {
        return ResponseEntity.ok(driverService.getAssignedDrivers().stream().map(Driver::mapToDto).toList());
    }
}