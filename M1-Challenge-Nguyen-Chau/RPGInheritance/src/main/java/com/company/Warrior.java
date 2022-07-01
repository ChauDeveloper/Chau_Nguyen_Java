package com.company;

public class Warrior extends Character {
    protected int shieldStrength = 100;
    @Override
    public void setStrength(int strength) {
        super.setStrength(strength);
    }

    @Override
    public void setHealth(int health) {
        super.setHealth(100);
    }

    @Override
    public void setStamina(int stamina) {
        super.setStamina(100);
    }

    @Override
    public void setSpeed(int speed) {
        super.setSpeed(50);
    }

    @Override
    public void setAttackPower(int attackPower) {
        super.setAttackPower(10);
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
