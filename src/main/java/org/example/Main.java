package org.example;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello and welcome!");

        Manufacturer man = new Manufacturer("BMW", "Germany");
        Car car = new Car("X5-M", man, 10);

        System.out.println(man);
    }
}