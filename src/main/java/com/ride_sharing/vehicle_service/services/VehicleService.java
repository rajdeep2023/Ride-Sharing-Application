package com.ride_sharing.vehicle_service.services;

import com.ride_sharing.vehicle_service.entities.Vehicle;
import com.ride_sharing.vehicle_service.exceptions.ResourceNotFoundException;
import com.ride_sharing.vehicle_service.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    //    public VehicleService(VehicleRepository vehicleRepository) {
    //        this.vehicleRepository = vehicleRepository;
    //    }


    // Create new vehicle
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    // Update Vehicle by VehicleId
    public Vehicle updateVehicle(Long vehicleId, Vehicle vehicleDetails) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        vehicle.setLicensePlate(vehicleDetails.getLicensePlate());
        vehicle.setModel(vehicleDetails.getModel());
        vehicle.setYear(vehicleDetails.getYear());
        return vehicleRepository.save(vehicle);
    }


    // Delete Vehicle by VehicleId

    //    public void deleteVehicle(Long vehicleId) {
    //        vehicleRepository.deleteById(vehicleId);
    //    }

    public String deleteVehicle(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found with ID: " + vehicleId));
        vehicleRepository.delete(vehicle);
        return "Vehicle with ID " + vehicleId + " has been successfully deleted.";
    }


    // Get all Vehicles
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    // Get Vehicle by DriverId

    //    public List<Vehicle> getVehiclesByDriverId(Long driverId) {
    //        return vehicleRepository.findByDriverId(driverId);
    //    }

    public List<Vehicle> getVehiclesByDriverId(Long driverId) {
        List<Vehicle> vehicles = vehicleRepository.findByDriverId(driverId);
        if (vehicles.isEmpty()) {
            throw new ResourceNotFoundException("No vehicles found for driver with ID: " + driverId);
        }
        return vehicles;
    }


    // Get Vehicle by VehicleId
    public Vehicle getVehicleById(Long vehicleId) {
        return vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }
}
