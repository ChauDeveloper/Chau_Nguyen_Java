package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterIfTest {

    @Test
    public void shouldShowAppropriateMonthWhenInputAnyNumbersFromOneToTwelve(){
        Converter test = new ConverterIf();
        String expectedValue = "May";
        String actualValue = test.convertMonth(5);
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void shouldShowAnErrorMessageWhenInputAnythingElseOtherThanOneToTwelve() {
        Converter test = new ConverterIf();
        String expectedValue = "Please only input number 1-12 to convert month";
        String actualValue = test.convertMonth(200);
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void shouldShowAppropriateDayWhenInputAnyNumbersFromOneToSeven(){
        Converter test = new ConverterIf();
        String expectedValue = "Tuesday";
        String actualValue = test.convertDay(3);
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void shouldShowAppropriateDayWhenInputAnythingElseOtherThanOneToSeven(){
        Converter test = new ConverterIf();
        String expectedValue = "Please only input number 1-7 to convert day";
        String actualValue = test.convertDay(8);
        assertEquals(expectedValue,actualValue);
    }

}