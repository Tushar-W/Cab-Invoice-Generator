package com.bl;

import com.bl.service.CabInvoiceService;
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
        double distance = 5.0;
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
}
