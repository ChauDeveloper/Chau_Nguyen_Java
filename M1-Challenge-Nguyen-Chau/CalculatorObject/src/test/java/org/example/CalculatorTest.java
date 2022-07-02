package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator test = new Calculator();
    public void setUp(){
        test = new Calculator();
    }

    @Test
    public void shouldReturnSumOfTwoIngeters() {
        int expectedValue = 3;
        int actualValue = test.additional(-5,8);
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void shouldReturnSumOfTwoDoubles() {
        double expectedValue = 9.94;
        double actualValue = test.additional(4.74,5.2);
        assertEquals(expectedValue,actualValue,0.000001);
    }

    @Test
    public void shouldReturnSubtractionOfTwoIngeters() {
        int expectedValue = -2;
        int actualValue = test.subtraction(-5,-3);
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void shouldReturnSubtractionOfTwoDoubles() {
        double expectedValue = 3.1;
        double actualValue = test.subtraction(5.4,2.3);
        assertEquals(expectedValue,actualValue,0.000001);
    }

    @Test
    public void shouldReturnMultiplicationOfTwoIngeters() {
        int expectedValue = 15;
        int actualValue = test.multiplication(-5,-3);
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void shouldReturnMultiplicationOfTwoDoubles() {
        double expectedValue = 12.42;
        double actualValue = test.multiplication(5.4,2.3);
        assertEquals(expectedValue,actualValue,0.000001);
    }

    @Test
    public void shouldReturnDivisionOfTwoIngeters() {
        int expectedValue = 2;
        int actualValue = test.division(8,3);
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void shouldReturnDivisionOfTwoDoubles() {
        double expectedValue = 2.8;
        double actualValue = test.division(5.6,2);
        assertEquals(expectedValue,actualValue,0.000001);
    }
}