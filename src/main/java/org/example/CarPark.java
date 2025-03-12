package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarPark {
    private List<Car> cars = new ArrayList<Car>();
    private int carsCount = 0;
    public void addCar(Car car) {
        cars.add(car);
        carsCount+=1;
    }
    public void deleteCar(Car car) {
        cars.remove(car);
        carsCount-=1;
    }
    public int getCarsCount() {return carsCount;}
    public List<Car> getCars() {return new ArrayList<>(cars);}

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
