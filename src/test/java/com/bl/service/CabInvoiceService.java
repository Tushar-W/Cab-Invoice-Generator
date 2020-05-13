package com.bl.service;

public class CabInvoiceService {


    private static double COST_PER_MINUTE = 1;
    private static double COST_PER_KILOMETER = 10.0;

    public double calculateFare(double distance, int time) {
       return  distance * COST_PER_KILOMETER + time * COST_PER_MINUTE;
    }
}
