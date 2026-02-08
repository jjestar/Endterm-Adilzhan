package com.rental.api.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ReservationRequestDTO {
    private Long vehicleId;
    private String clientName;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean insurance;
    private boolean wifi;
}