package com.company;

public class ConverterApplication {
    public static void main(String[] args) {
        int month =2;
        int day=2;
        Converter c1 = new ConverterIf();
        Converter c2 = new ConverterSwitch();

        System.out.println("This would print out the according month (2,February) using ConverterIf method: " + c1.convertMonth(month));
        System.out.println("This would print out the according day (2, Monday) using ConverterIf method: " + c1.convertMonth(day));
        System.out.println("This would print out the according month (2,February) using ConverterSwitch method: "+ c2.convertMonth(month));
        System.out.println("This would print out the according day (2, Monday) using ConverterSwitch method: " + c2.convertMonth(day));
    }
}
