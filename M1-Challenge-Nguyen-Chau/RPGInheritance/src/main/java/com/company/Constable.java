package com.company;

public class Constable extends Character{

    protected String jurisdiction;
    public Constable(String name){
        super(60, 100, 60, 20, 5);
        this.name = name;
    }

    public void arrest(Character oponent){
        oponent.arrested = true;
        oponent.setRunning(false);
        this.setStamina(this.getStamina() - 10);
        this.setStrength(this.getStrength()-10);
        System.out.println(oponent.name + " is arrested by " + this.name + " . " + this.name + " is tired by chasing " + oponent.name + " ." + this.name + "'s current strength and stamina are " + this.strength + " and " + this.stamina);
    }
    
}
