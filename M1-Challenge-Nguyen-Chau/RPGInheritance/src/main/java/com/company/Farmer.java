package com.company;

public class Farmer extends Character{
    protected boolean plowing= false;
    protected boolean harvesting=false;
    public Farmer(){}
    public Farmer(String name) {
        super(75, 100, 75, 50, 1);
        this.name = name;
    }




    public boolean isPlowing() {
        return plowing;
    }

    public void setPlowing(boolean plowing) {
        this.plowing = plowing;
    }

    public boolean isHarvesting() {
        return harvesting;
    }

    public void setHarvesting(boolean harvesting) {
        this.harvesting = harvesting;
    }
}
