package com.graphqlexample.api;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqlexample.entity.Vehicle;
import com.graphqlexample.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VehicleQueryResolver implements GraphQLQueryResolver {

    private final VehicleService vehicleService;
    public List<Vehicle> getAllVehicles(String type){
        return vehicleService.getVehicleByType(type);
    }

    public Optional<Vehicle> getVehicleById(Long id){
        return vehicleService.getVehicleById(id);
    }
}
