package org.example.factory;

import org.example.factory.IceCream;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IceCreamTest {
    private IceCream factoryTest;
    @Before
    public void setUp(){
        factoryTest = new IceCream();
    }

    @Test
    public void createdNewRecipeAfterInputtingFlavorToppingSugarAndMilkInfo(){
        String expectedOutput = "Ingredients of " + "Birthday Cake" + " ice cream: \n" +
                "Flavor: " +"Vanilla"+ "\n" +
                "Topping: " + "Rainbow Sprinkle" + "\n" +
                "Sugar: " + 50 + "\n" +
                "Milk: " + 200;

        String actualOutput = factoryTest.createRecipe("Birthday Cake", "Vanilla","Rainbow Sprinkle", 50, 200);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void salePriceShouldBeReturnedWhenCalculatePricePerUnitRuns(){
        int expectedOutPut = 50;
        int actualOutput = factoryTest.calculatePricePerUnit(50);
        assertEquals(expectedOutPut, actualOutput);
    }

    @Test
    public void shouldReturnTotalProductionSalePriceWhenInputSalePriceAndTotalProduct (){
        int expectedOutput = 100000;
        int actualOutput = factoryTest.calculateTotalProductionSalePrice(50,2000);
        assertEquals(expectedOutput,actualOutput);
        
    }
}