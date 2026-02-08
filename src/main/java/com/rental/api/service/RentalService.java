package com.rental.api.service;

import com.rental.api.dto.ReservationRequestDTO;
import com.rental.api.dto.VehicleRequestDTO;
import com.rental.api.exception.ResourceNotFoundException;
import com.rental.api.model.Reservation;
import com.rental.api.model.Vehicle;
import com.rental.api.model.LuxuryCar;
import com.rental.api.patterns.BusinessConfig;
import com.rental.api.patterns.VehicleFactory;
import com.rental.api.repository.ReservationRepository;
import com.rental.api.repository.VehicleRepository;
import com.rental.api.utils.RentalPriceCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final VehicleRepository vehicleRepository;
    private final ReservationRepository reservationRepository;
    private final VehicleFactory vehicleFactory;
    private final RentalPriceCalculator priceCalculator;

    public Vehicle createVehicle(VehicleRequestDTO dto) {
        Vehicle vehicle = vehicleFactory.createVehicle(
                dto.getType(),
                dto.getBrand(),
                dto.getModel(),
                dto.getPrice()
        );
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public void deleteVehicle(Long id) {
        if (!vehicleRepository.existsById(id)) {
            throw new ResourceNotFoundException("Vehicle not found");
        }
        vehicleRepository.deleteById(id);
    }

    public Reservation createReservation(ReservationRequestDTO dto) {
        Vehicle vehicle = vehicleRepository.findById(dto.getVehicleId())
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));

        Reservation.Builder builder = new Reservation.Builder()
                .client(dto.getClientName())
                .dates(dto.getStartDate(), dto.getEndDate())
                .vehicle(vehicle);

        if (dto.isInsurance()) builder.withInsurance();
        if (dto.isWifi()) builder.withWifi();

        Reservation reservation = builder.build();

        long days = priceCalculator.calculateDays(dto.getStartDate(), dto.getEndDate());
        double baseCost = days * vehicle.getBasePricePerDay();

        double discount = priceCalculator.calculateDiscount(days);
        double costAfterDiscount = baseCost * (1 - discount);

        String category = (vehicle instanceof LuxuryCar) ? "LUXURY" : "STANDARD";
        double taxRate = BusinessConfig.getInstance().getTaxRate(category);

        double priceWithTax = priceCalculator.applyTax(costAfterDiscount, taxRate);

        if (dto.isInsurance()) {
            priceWithTax += 50 * days;
        }

        reservation.setTotalPrice(priceWithTax);

        return reservationRepository.save(reservation);
    }
}