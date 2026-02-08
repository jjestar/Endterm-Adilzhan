package com.rental.api.dto;

import com.rental.api.model.VehicleType;
import lombok.Data;

@Data
public class VehicleRequestDTO {
    private String brand;
    private String model;
    private double price;
    private VehicleType type;
}