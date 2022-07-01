package com.company;

public class Farmer extends Character{
    protected boolean plowing= false;
    protected boolean harvesting=false;

    @Override
    public void setStrength(int strength) {
        super.setStrength(75);
    }

    @Override
    public void setHealth(int health) {
        super.setHealth(100);
    }

    @Override
    public void setStamina(int stamina) {
        super.setStamina(75);
    }

    @Override
    public void setSpeed(int speed) {
        super.setSpeed(10);
    }

    @Override
    public void setAttackPower(int attackPower) {
        super.setAttackPower(1);
    }

    @Override
    public void setRunning(boolean running) {
        super.setRunning(false);
    }

    @Override
    public void setArrested(boolean arrested) {
        super.setArrested(false);
    }

}
