package com.company;

public class Constable extends Character{

    protected String jurisdiction;
    @Override
    public void setStrength(int strength) {
        super.setStrength(60);
    }

    @Override
    public void setHealth(int health) {
        super.setHealth(100);
    }

    @Override
    public void setStamina(int stamina) {
        super.setStamina(60);
    }

    @Override
    public void setSpeed(int speed) {
        super.setSpeed(20);
    }

    @Override
    public void setAttackPower(int attackPower) {
        super.setAttackPower(5);
    }

    @Override
    public void setRunning(boolean running) {
        super.setRunning(false);
    }

    @Override
    public void setArrested(boolean arrested) {
        super.setArrested(false);
    }

    public void arrest(Constable enemy){
        enemy.arrested = true;
    }
    
}
