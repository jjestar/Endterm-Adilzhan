package com.rental.api.patterns;

import com.rental.api.model.LuxuryCar;
import com.rental.api.model.StandardCar;
import com.rental.api.model.Vehicle;
import com.rental.api.model.VehicleType;
import org.springframework.stereotype.Component;

@Component
public class VehicleFactory {
    public Vehicle createVehicle(VehicleType type, String brand, String model, double price) {
        if (type == VehicleType.LUXURY) {
            return new LuxuryCar(brand, model, price, true);
        } else if (type == VehicleType.STANDARD) {
            return new StandardCar(brand, model, price, false);
        }
        throw new IllegalArgumentException("Unknown vehicle type");
    }
}