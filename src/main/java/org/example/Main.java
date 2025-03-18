package org.example;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        CarPark carPark = new CarPark();
        Manufacturer honda = new Manufacturer("honda", "Japan");
        Car car1 = new Car("Civic", honda, 50);
        Car car2 = new Car("CH-R", honda, 60);
        carPark.addCar(car1);
        carPark.addCar(car2);
        System.out.println(carPark.getCars().toString());
        car2.drive(40,1);


        carPark.sortCars(Comparator.comparingDouble(Car::getFuelLevel));
        XMLExporter.ExportToXml(carPark, "CarPark.xml");
    }
}