package com.example.hackweekbackend.driver.controller;

import com.example.hackweekbackend.driver.model.AddDriverDto;
import com.example.hackweekbackend.driver.model.Driver;
import com.example.hackweekbackend.driver.model.DriverDto;
import com.example.hackweekbackend.driver.service.DriverService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/driver")
public class DriverController {
    private final DriverService driverService;

    @PostMapping
    ResponseEntity<DriverDto> createDriver(@RequestBody AddDriverDto addDriverDto) {
        DriverDto driverDto = driverService.createDriver(new Driver(addDriverDto)).mapToDto();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("location", "/api/assignment/" + driverDto.id())
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
}