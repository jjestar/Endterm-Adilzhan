package com.rental.api.patterns;

import java.util.HashMap;
import java.util.Map;

public class BusinessConfig {
    private static BusinessConfig instance;
    private final Map<String, Double> taxRates;

    private BusinessConfig() {
        taxRates = new HashMap<>();
        taxRates.put("LUXURY", 0.15);
        taxRates.put("STANDARD", 0.05);
    }

    public static synchronized BusinessConfig getInstance() {
        if (instance == null) {
            instance = new BusinessConfig();
        }
        return instance;
    }

    public double getTaxRate(String category) {
        return taxRates.getOrDefault(category, 0.10);
    }
}