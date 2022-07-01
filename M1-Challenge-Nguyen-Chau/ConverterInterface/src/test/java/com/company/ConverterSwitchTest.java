package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterSwitchTest {
    @Test
    public void shouldShowAppropriateMonthWhenInputAnyNumbersFromOneToTwelve(){
        Converter test = new ConverterSwitch();
        String expectedValue = "November";
        String actualValue = test.convertMonth(11);
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void shouldShowAnErrorMessageWhenInputAnythingElseOtherThanOneToTwelve() {
        Converter test = new ConverterSwitch();
        String expectedValue = "Hello, I only understand number 1-12";
        String actualValue = test.convertMonth(-15);
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void shouldShowAppropriateDayWhenInputAnyNumbersFromOneToSeven(){
        Converter test = new ConverterSwitch();
        String expectedValue = "Saturday";
        String actualValue = test.convertDay(7);
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void shouldShowAppropriateDayWhenInputAnythingElseOtherThanOneToSeven(){
        Converter test = new ConverterSwitch();
        String expectedValue = "Hello, I only understand number 1-7";
        String actualValue = test.convertDay(-23);
        assertEquals(expectedValue,actualValue);
    }
}