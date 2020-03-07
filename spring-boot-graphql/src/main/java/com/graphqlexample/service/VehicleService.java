package com.graphqlexample.service;

import com.graphqlexample.entity.Vehicle;
import com.graphqlexample.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    public List<Vehicle> getVehicleByType(String type) {
        return vehicleRepository.getByVehicleType(type);
    }

    public Optional<Vehicle> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

    public Vehicle save(Vehicle vehicle) {
        return  vehicleRepository.save(vehicle);
    }
}
