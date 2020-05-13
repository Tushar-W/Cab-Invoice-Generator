package com.bl.service;

public class CabInvoiceService {


    private static final double MINIMUM_FARE = 5;
    private static final double COST_PER_MINUTE = 1;
    private static final double COST_PER_KILOMETER = 10;

    public double calculateFare(double distance, int time) {
        double totalFare = distance * COST_PER_KILOMETER + time * COST_PER_MINUTE;
        if (totalFare < MINIMUM_FARE)
            return MINIMUM_FARE;
        return totalFare;
    }
}
