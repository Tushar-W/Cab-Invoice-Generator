package com.bl.service;

public class CabInvoiceService {

    private static final double MINIMUM_FARE = 5;
    private static final double COST_PER_MINUTE = 1;
    private static final double COST_PER_KILOMETER = 10;
    private RideRepository rideRepository;


    public CabInvoiceService() {
        this.rideRepository = new RideRepository();
    }

    public double calculateFare(double distance, int time) {
        double totalFare = distance * COST_PER_KILOMETER + time * COST_PER_MINUTE;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride:rides) {
             totalFare += this.calculateFare(ride.distance,ride.time);
        }
        return new InvoiceSummary(rides.length,totalFare);
    }

    public void addRides(String userId, Ride[] rides) {
       rideRepository.addRides(userId,rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRide(userId));
    }
}
