package com.ride_sharing.vehicle_service.controller;

import com.ride_sharing.vehicle_service.entities.Vehicle;
import com.ride_sharing.vehicle_service.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    //    public VehicleController(VehicleService vehicleService) {
    //        this.vehicleService = vehicleService;
    //    }

    // Create new vehicle
    @PostMapping
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(vehicleService.addVehicle(vehicle));
    }

    // Update Vehicle by VehicleId
    @PutMapping("/{vehicleId}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long vehicleId, @RequestBody Vehicle vehicleDetails) {
        return ResponseEntity.ok(vehicleService.updateVehicle(vehicleId, vehicleDetails));
    }

    // Delete Vehicle by VehicleId

    //    @DeleteMapping("/{vehicleId}")
    //    public ResponseEntity<Void> deleteVehicle(@PathVariable Long vehicleId) {
    //        vehicleService.deleteVehicle(vehicleId);
    //        return ResponseEntity.noContent().build();
    //    }

    @DeleteMapping("/{vehicleId}")
    public ResponseEntity<String> deleteVehicle(@PathVariable Long vehicleId) {
        String message = vehicleService.deleteVehicle(vehicleId);
        return ResponseEntity.ok(message);
    }


    // Get all Vehicles
    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    // Get Vehicles by DriverId
    @GetMapping("/driver/{driverId}")
    public ResponseEntity<List<Vehicle>> getVehiclesByDriverId(@PathVariable Long driverId) {
        return ResponseEntity.ok(vehicleService.getVehiclesByDriverId(driverId));
    }

    // Get Vehicles by VehicleId
    @GetMapping("/{vehicleId}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long vehicleId) {
        return ResponseEntity.ok(vehicleService.getVehicleById(vehicleId));
    }
}
