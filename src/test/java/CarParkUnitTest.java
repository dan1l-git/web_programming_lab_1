package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class CarParkUnitTest {
    private CarPark carPark;
    private Car car1;
    private Car car2;

    private Manufacturer toyota = new Manufacturer("Toyota", "Japan");
    private Manufacturer honda = new Manufacturer("Honda", "Japan");

    @BeforeEach
    void setUp() {
        carPark = new CarPark();
        car1 = new Car("Corolla", toyota, 50);
        car2 = new Car("Civic", honda, 50);
    }

    @Test
    void testCarParkAddCar() {
        carPark.addCar(car1);
        assertEquals(1, carPark.getCarsCount());
        assertTrue(carPark.getCars().contains(car1));
    }

    @Test
    void testCarParkDeleteCar() {
        carPark.addCar(car1);
        carPark.deleteCar(car1);
        assertEquals(0, carPark.getCarsCount());
        assertFalse(carPark.getCars().contains(car1));
    }

    @Test
    void testCarParkDeleteCar_NotInList() {
        assertThrows(ArrayStoreException.class, () -> carPark.deleteCar(car1));
    }

    @Test
    void testCarParkGetCarsCount() {
        carPark.addCar(car1);
        carPark.addCar(car2);
        assertEquals(2, carPark.getCarsCount());
    }

    @Test
    void testCarParkGetCars_ReturnsCopy() {
        carPark.addCar(car1);
        List<Car> cars = carPark.getCars();
        cars.add(car2);
        assertEquals(1, carPark.getCarsCount());
    }

    @Test
    void testCarParkEquals() {
        carPark.addCar(car1);
        CarPark anotherCarPark = new CarPark();
        anotherCarPark.addCar(car1);
        assertEquals(carPark, anotherCarPark);
    }

    @Test
    void testCarParkEquals_DifferentObjects() {
        carPark.addCar(car1);
        CarPark anotherCarPark = new CarPark();
        anotherCarPark.addCar(car2);
        assertNotEquals(carPark, anotherCarPark);
    }

    @Test
    void testCarParkHashCode_Consistency() {
        carPark.addCar(car1);
        int hash1 = carPark.hashCode();
        int hash2 = carPark.hashCode();
        assertEquals(hash1, hash2);
    }
}
