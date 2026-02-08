package com.rental.api.utils;

import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class RentalPriceCalculator {

    public long calculateDays(LocalDate start, LocalDate end) {
        long days = ChronoUnit.DAYS.between(start, end);
        return days <= 0 ? 1 : days;
    }

    public double calculateDiscount(long days) {
        if (days > 30) return 0.20;
        if (days > 7) return 0.10;
        return 0.0;
    }

    public double applyTax(double amount, double taxRate) {
        return amount * (1 + taxRate);
    }
}