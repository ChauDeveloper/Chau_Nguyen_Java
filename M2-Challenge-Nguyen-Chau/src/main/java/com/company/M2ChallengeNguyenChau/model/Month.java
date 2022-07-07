package com.company.M2ChallengeNguyenChau.model;

import java.util.Objects;

public class Month {
    private String name;
    private int number;

    public Month(String name, int number) {
        this.name = name;
        this.number = number;
    }
    public Month(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Month month = (Month) o;
        return number == month.number && Objects.equals(name, month.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    @Override
    public String toString() {
        return "Month{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
