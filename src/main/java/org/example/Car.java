package org.example;

import java.util.Objects;

public class Car {
    private String model;
    private Manufacturer manufacturer;
    private int mileage;
    private double fuelLevel;
    private double fuelCapacity;

    public Car(String model, Manufacturer manufacturer, double fuelCapacity) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.fuelCapacity = fuelCapacity;
        this.fuelLevel = fuelCapacity;
        this.mileage = 0;
    }

    public String getModel() {return model;}
    public void setModel(String model) {this.model = model;}

    public String getManufacturer() {return manufacturer.toString();}
    public void setManufacturer(Manufacturer manufacturer) {this.manufacturer = manufacturer;}

    public void drive(int distance, double fuelConsumptionPerKilometer) {
        double neededFuel = distance * fuelConsumptionPerKilometer;

        if(neededFuel > fuelLevel) {
            System.out.println("Not enough fuel to drive " + distance + " kilometers");
        }
        else{
            this.mileage += distance;
            this.fuelLevel -= neededFuel;
        }
    }

    public void refuel(double amount) {
        if( fuelLevel + amount > fuelCapacity) {
            fuelLevel = fuelCapacity;
        }
        else{
            fuelLevel += amount;
        }
    }

    @Override
    public String toString() {
        return "Car " + manufacturer.getName() + " " + model + ". Mileage: " + mileage + ". Fuel level: " + fuelLevel + "/" + fuelCapacity;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Car other)) return false;

        return Objects.equals(model, other.model) && Objects.equals(manufacturer, other.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, manufacturer, mileage, fuelLevel, fuelCapacity);
    }
}
