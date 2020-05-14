package com.bl;

import service.CabInvoiceService;
import service.Ride;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceServiceTest {
    CabInvoiceService cabInvoiceService = null;

    @Before
    public void setUp() throws Exception {
        cabInvoiceService = new CabInvoiceService();
    }

    @Test
    public void GivenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 5;
        int time = 3;
        double fare = cabInvoiceService.calculateFare(distance, time);
        Assert.assertEquals(53,fare,0.0);
    }

    @Test
    public void GivenLessDistanceOrTime_ShouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        double fare = cabInvoiceService.calculateFare(distance, time);
        Assert.assertEquals(5,fare,0.0);
    }

    @Test
    public void GivenMultipleRides_ShouldReturnTotalFare() {
        Ride[] rides = { new Ride(5, 3),
                         new Ride(0.1, 1)
                        };
        double fare = cabInvoiceService.calculateFare(rides);
        Assert.assertEquals(58,fare,0.0);
    }
}

