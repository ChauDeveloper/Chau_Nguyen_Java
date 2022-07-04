package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RPGInheritanceTest {
    private Character dwight;
    private Constable michael;
    private Character jim;

    @Before
    public void setUp(){
        dwight = new Farmer("Dwight");
        michael = new Constable("Michael Scott");
        jim = new Warrior("Jim");
    }

    @Test
    public void aCharactersHealthShouldBeDeductedAfterBeingAttacked (){
        dwight.attack(jim);
        int expectedValue = 99;
        int actualValue = jim.getHealth();
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void afterConstableArrestACharacterHisStrengthAndStaminaReduced(){
        michael.arrest(dwight);
        int[] expectedValue = {50,50};
        int[] actualValue = {michael.getStrength(), michael.getStamina()};
        assertArrayEquals(expectedValue, actualValue);
    }

    @Test
    public void afterConstableArrestACharacterThatCharacterArrestStateChangeToTrue(){
        michael.arrest(dwight);
        boolean expectedValue = true;
        boolean actualValue = dwight.isArrested();
        assertEquals(expectedValue,actualValue);
    }

}