package org.example;

import java.util.Comparator;
import java.util.List;

import jakarta.xml.bind.JAXBException;

public class Main {

    public static void main(String[] args) throws JAXBException {
        System.out.println("Let`s test our CarPark!");
        System.out.println("First, lets create a new car park and fill it:");
        System.out.println();

        CarPark carPark = new CarPark();
        Manufacturer honda = new Manufacturer("honda", "Japan");
        Car car1 = new Car("Civic", honda, 50);
        Car car2 = new Car("CH-R", honda, 60);
        carPark.AddCar(car2);
        carPark.AddCar(car1);
        System.out.println(carPark.GetCars().toString());
        System.out.println();

        System.out.println("Now, lets ride some miles: ");
        System.out.println(car1.Drive(10,1));
        System.out.println(carPark.GetCars().toString());
        System.out.println();

        System.out.println("Now, lets sort our car park by fuel level: ");
        carPark.SortCars(Comparator.comparingDouble(Car::getFuelLevel));
        System.out.println(carPark.GetCars().toString());
        System.out.println();

        System.out.println("Now we export the cars into a file: ");
        XMLExporter.ExportToXml(carPark, "CarPark.xml");
        System.out.println();

        System.out.println("Now we Import the cars into a new car park and print them: ");
        CarPark carPark1 = XMLImporter.ImportFromXml("carPark.xml");
        List<Car> cars = carPark1.GetCars();
        for (Car car : cars) {
            System.out.println(car.toString());
        }
        System.out.println();

        System.out.println("Now let`s see if these two car parks are the same: ");
        System.out.println(carPark.equals(carPark1));

    }
}