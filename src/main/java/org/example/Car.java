package org.example;

import java.util.Objects;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "car")
public class Car {
    private String model;
    private Manufacturer manufacturer;
    @XmlElement
    private int mileage;
    @XmlElement
    private double fuelLevel;
    private double fuelCapacity;

    public Car(){}

    public Car(String model, Manufacturer manufacturer, double fuelCapacity) {

        if(model.isBlank()){throw new IllegalArgumentException("Model cannot be blank.");}
        if(fuelCapacity < 0){throw new IllegalArgumentException("fuelCapacity must be greater than 0");}

        this.model = model;
        this.manufacturer = manufacturer;
        this.fuelCapacity = fuelCapacity;
        this.fuelLevel = fuelCapacity;
        this.mileage = 0;
    }

    @XmlElement
    public String getModel() {return model;}
    public void setModel(String model) {
        if(!(model.isBlank())){
            this.model = model;
        } else {throw new IllegalArgumentException("Model cannot be blank.");}
    }

    @XmlElement
    public Manufacturer getManufacturer() {return manufacturer;}
    public void setManufacturer(Manufacturer manufacturer) {this.manufacturer = manufacturer;}

    public double getFuelLevel() {return fuelLevel;}
    public int getMileage() {return mileage;}

    public String Drive(int distance, double fuelConsumptionPerKilometer) {

        if (distance < 0 || fuelConsumptionPerKilometer < 0) {
            throw new IllegalArgumentException("Distance and fuel consumption must be positive!");
        }

        double neededFuel = distance * fuelConsumptionPerKilometer;

        if(neededFuel > fuelLevel) {
            return "Not enough fuel to drive " + distance + " kilometers";
        }
        else{
            this.mileage += distance;
            this.fuelLevel -= neededFuel;
            return "Driving " + distance + " kilometers";
        }
    }

    public String Refuel(double amount) {

        if(amount < 0) {throw new IllegalArgumentException("Amount must be positive!");}

        if( fuelLevel + amount > fuelCapacity) {
            fuelLevel = fuelCapacity;
            return "Fuel level limit reached";
        }
        else{
            fuelLevel += amount;
            return "Added " + amount+ " liters. Fuel level: " + fuelLevel;
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
