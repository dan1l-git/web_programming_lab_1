package org.example;

import java.io.File;
import java.util.Comparator;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class Main {

    public static void main(String[] args) throws JAXBException {
        CarPark carPark = new CarPark();
        Manufacturer honda = new Manufacturer("honda", "Japan");
        Car car1 = new Car("Civic", honda, 50);
        Car car2 = new Car("CH-R", honda, 60);
        Car car3 = new Car("Accord", honda, 60);
        carPark.addCar(car1);
        carPark.addCar(car2);
        carPark.addCar(car3);
        System.out.println(carPark.getCars().toString());
        car2.drive(30,1);
        carPark.sortCars(Comparator.comparingDouble(Car::getFuelLevel));
        XMLExporter.ExportToXml(carPark, "CarPark.xml");
        CarPark carPark1 = XMLImporter.ImportFromXml("carPark.xml");
        List<Car> cars = carPark1.getCars();
        for (Car car : cars) {
            System.out.println(car.toString());
        }
        System.out.println(carPark.equals(carPark1));


    }
}