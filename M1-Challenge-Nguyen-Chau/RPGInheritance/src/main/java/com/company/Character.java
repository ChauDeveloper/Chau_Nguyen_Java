package com.company;

public class Character {
    protected String name;
    protected int strength;
    protected int health = 100;
    protected int stamina;
    protected int speed;
    protected int attackPower;
    protected boolean running;
    protected boolean arrested;

    public Character() {

    };
    public Character(String name){
        this.name = name;
    }

    public Character(int strength, int health, int stamina, int speed, int attackPower) {
        this.strength = strength;
        this.health = health;
        this.stamina = stamina;
        this.speed = speed;
        this.attackPower = attackPower;
    }

    public Character(String name, int strength, int health, int stamina, int speed, int attackPower, boolean running, boolean arrested) {
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.stamina = stamina;
        this.speed = speed;
        this.attackPower = attackPower;
        this.running = running;
        this.arrested = arrested;
    }



    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStamina() {
        return this.stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackPower() {
        return this.attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public boolean isRunning() {
        return this.running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isArrested() {
        return this.arrested;
    }

    public void setArrested(boolean arrested) {
        this.arrested = arrested;
    }

    public void attack(Character oponent){
        int a = oponent.getHealth()- this.getAttackPower();
        oponent.setHealth(a);
        System.out.println(
                this.getName() + " attacked " + oponent.name + " ." + oponent.name + "'s current Health is " + a
        );
    }

}
