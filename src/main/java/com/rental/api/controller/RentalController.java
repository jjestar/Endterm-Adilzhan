package com.rental.api.controller;

import com.rental.api.dto.ReservationRequestDTO;
import com.rental.api.dto.VehicleRequestDTO;
import com.rental.api.model.Reservation;
import com.rental.api.model.Vehicle;
import com.rental.api.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;

    @PostMapping("/vehicles")
    public ResponseEntity<Vehicle> addVehicle(@RequestBody VehicleRequestDTO dto) {
        return ResponseEntity.ok(rentalService.createVehicle(dto));
    }

    @GetMapping("/vehicles")
    public ResponseEntity<List<Vehicle>> getVehicles() {
        return ResponseEntity.ok(rentalService.getAllVehicles());
    }

    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        rentalService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/reservations")
    public ResponseEntity<Reservation> bookVehicle(@RequestBody ReservationRequestDTO dto) {
        return ResponseEntity.ok(rentalService.createReservation(dto));
    }
}