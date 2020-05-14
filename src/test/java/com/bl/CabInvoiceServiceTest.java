package com.bl;

import com.bl.service.CabInvoiceService;
import com.bl.service.InvoiceSummary;
import com.bl.service.Ride;
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
    public void givenDistanceAndTime_WhenProper_ShouldReturnTotalFare() {
        double distance = 5;
        int time = 3;
        double fare = cabInvoiceService.calculateFare(distance, time);
        Assert.assertEquals(53,fare,0.0);
    }

    @Test
    public void givenLessDistanceOrTime_WhenProper_ShouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        double fare = cabInvoiceService.calculateFare(distance, time);
        Assert.assertEquals(5,fare,0.0);
    }

    @Test
    public void givenMultipleRides_WhenProper_ShouldReturnInvoiceSummary() {
        Ride[] rides = { new Ride(5, 3),
                         new Ride(0.1, 1)
        };
        InvoiceSummary summary = cabInvoiceService.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 58.0);
        Assert.assertEquals(expectedInvoiceSummary,summary);
    }

    @Test
    public void givenUserIdAndRides_WhenProper_ShouldReturnInvoiceSummary() {
        String userId = "abc@d";
        Ride[] rides = { new Ride(5, 3),
                         new Ride(0.1, 1)
        };
        cabInvoiceService.addRides(userId,rides);
        InvoiceSummary summary = cabInvoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 58.0);
        Assert.assertEquals(expectedInvoiceSummary,summary);
    }
}

