package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Comparator;

@XmlRootElement
public class CarPark {
    public CarPark() {}
    @XmlElement
    private List<Car> cars = new ArrayList<Car>();
    @XmlElement
    private int carsCount = 0;
    public void addCar(Car car) {
        cars.add(car);
        carsCount+=1;
    }
    public void deleteCar(Car car) {
        if(cars.contains(car)){
            cars.remove(car);
            carsCount-=1;
        }
        else{throw new ArrayStoreException("Car is not in the car list");}
    }
    public int getCarsCount() {return carsCount;}

    public List<Car> getCars() {return new ArrayList<>(cars);}

    public void sortCars(Comparator<Car> comparator) {
        cars.sort(comparator);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof CarPark other)) return false;

        return Objects.equals(getCars(), other.getCars());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCars());
    }
}
