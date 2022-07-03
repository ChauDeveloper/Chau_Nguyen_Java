package org.example.pointofsale;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IceCreamTest {
    private IceCream pointOfSaleTest;
    @Before
    public void setUp(){
        pointOfSaleTest = new IceCream(3,5,1,false,true,250,3);
    }

    @Test
    public void shouldReturnOneDollarWhenCustomerChooseCone(){
        int expectedValue = 1;
        int actualValue = pointOfSaleTest.conePrice();
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void shouldReturnOneDollarBecauseCustomerDoesntChooseCup(){
        int expectedValue = 1;
        int actualValue = pointOfSaleTest.cupPrice();
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void shouldReturnTotalPriceForThisTestCustomer(){
        int expectedValue = 16 ;
        int actualValue = pointOfSaleTest.calculateOrderPrice();
    }

    @Test
    public void shouldReturnTotalEarnningPerDay(){
        int expectedValue = 4000;
        int actualValue = pointOfSaleTest.totalEarning();
    }

}