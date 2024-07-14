package com.example.hackweekbackend.truck.controller;

import com.example.hackweekbackend.truck.model.AddTruckDto;
import com.example.hackweekbackend.truck.model.Truck;
import com.example.hackweekbackend.truck.model.TruckDto;
import com.example.hackweekbackend.truck.service.TruckService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;
@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/truck")
public class TruckController {
    private final TruckService truckService;
    private final URI uri;

    @PostMapping
    ResponseEntity<TruckDto> createTruck(@RequestBody AddTruckDto addTruckDto) {
        TruckDto truckDto = truckService.createTruck(new Truck(addTruckDto)).mapToDto();
        return ResponseEntity.created(uri.resolve("/truck/"+truckDto.id()))
                .body(truckDto);
    }
    @GetMapping("/{truckId}")
    ResponseEntity<TruckDto> getTruck(@PathVariable UUID truckId) {
        return ResponseEntity.ok(truckService.getTruck(truckId).mapToDto());
    }

    @GetMapping
    ResponseEntity<List<TruckDto>> getTrucks() {
        return ResponseEntity.ok(truckService.getTrucks().stream().map(Truck::mapToDto).toList());
    }

    @DeleteMapping("/{truckId}")
    ResponseEntity<?> deleteTruck(@PathVariable UUID truckId) {
        truckService.deleteTruck(truckId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}