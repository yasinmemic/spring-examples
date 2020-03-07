package com.graphqlexample.api;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphqlexample.dto.VehicleDto;
import com.graphqlexample.entity.Vehicle;
import com.graphqlexample.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VehicleMutationResolver implements GraphQLMutationResolver {

    private final VehicleService vehicleService;

    public Vehicle createVehicle(VehicleDto vehicleDto) {
        return vehicleService.save(convertToEntity(vehicleDto));
    }

    public Vehicle convertToEntity(VehicleDto dto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrandName(dto.getBrandName());
        vehicle.setModelCode(dto.getModelCode());
        vehicle.setVehicleType(dto.getVehicleType());
        return vehicle;
    }
}
