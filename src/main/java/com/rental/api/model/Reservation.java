package com.rental.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientName;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean includeInsurance;
    private boolean includeWifi;
    private boolean includeChildSeat;
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    public static class Builder {
        private final Reservation reservation;

        public Builder() {
            this.reservation = new Reservation();
        }

        public Builder client(String name) {
            reservation.setClientName(name);
            return this;
        }

        public Builder dates(LocalDate start, LocalDate end) {
            reservation.setStartDate(start);
            reservation.setEndDate(end);
            return this;
        }

        public Builder withInsurance() {
            reservation.setIncludeInsurance(true);
            return this;
        }

        public Builder withWifi() {
            reservation.setIncludeWifi(true);
            return this;
        }

        public Builder vehicle(Vehicle v) {
            reservation.setVehicle(v);
            return this;
        }

        public Reservation build() {
            return reservation;
        }
    }
}