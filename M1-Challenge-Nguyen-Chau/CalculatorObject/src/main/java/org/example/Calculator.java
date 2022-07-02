package org.example;

public class Calculator {
    //additional method for two integer parameters and two double parameters.
    public int additional(int a, int b) {
        System.out.println(a + " + " + b + " = " + (a+b));
        return a + b;
    }
    public double additional(double a, double b) {
        System.out.println(a + " + " + b + " = " + (a+b));
        return a + b;
    }

    //subtraction method for two integer parameters and two double parameters.
    public int subtraction(int a, int b) {
        System.out.println(a + " - " + b + " = " + (a-b));
        return a - b;
    }
    public double subtraction(double a, double b) {
        System.out.println(a + " - " + b + " = " + (a-b));
        return a - b;
    }

    //multiplication method for two integer parameters and two double parameters.
    public int multiplication(int a, int b) {
        System.out.println(a + " * " + b + " = " + (a*b));
        return a * b;
    }
    public double multiplication(double a, double b) {
        System.out.println(a + " * " + b + " = " + (a*b));
        return a * b;
    }

    //division method for two integer parameters and two double parameters.
    public int division(int a, int b) {
        System.out.println(a + "/" + b + " = " + (a/b));
        return a / b;
    }
    public double division(double a, double b) {
        System.out.println(a + "/" + b + " = " + (a/b));
        return a / b;
    }

    public static void main(String[] args) {
        Calculator result = new Calculator();
        result.additional(1,1);
        result.subtraction(23,52);
        result.multiplication(34,2);
        result.division(12,3);
        result.division(12,7);
        result.additional(3.4,2.3);
        result.multiplication(6.7,4.4);
        result.subtraction(5.5,0.5);
        result.division(10.8,2.2);
    }
}
