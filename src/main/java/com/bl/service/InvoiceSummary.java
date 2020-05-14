package com.bl.service;

public class InvoiceSummary {
    public double average;
    public double totalFare;
    public int noOfRides;

    public InvoiceSummary(int noOfRides, double totalFare) {
        this.noOfRides = noOfRides;
        this.totalFare = totalFare;
        this.average = this.totalFare/this.noOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary summary = (InvoiceSummary) o;
        return Double.compare(summary.average, average) == 0 &&
                Double.compare(summary.totalFare, totalFare) == 0 &&
                noOfRides == summary.noOfRides;
    }

}
