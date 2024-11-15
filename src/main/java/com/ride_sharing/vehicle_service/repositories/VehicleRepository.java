package com.ride_sharing.vehicle_service.repositories;

import com.ride_sharing.vehicle_service.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    List<Vehicle> findByDriverId(Long driverId);

}
