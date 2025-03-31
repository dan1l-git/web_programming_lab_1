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
        carPark.AddCar(car1);
        assertEquals(1, carPark.GetCarsCount());
        assertTrue(carPark.GetCars().contains(car1));
    }

    @Test
    void testCarParkDeleteCar() {
        carPark.AddCar(car1);
        carPark.DeleteCar(car1);
        assertEquals(0, carPark.GetCarsCount());
        assertFalse(carPark.GetCars().contains(car1));
    }

    @Test
    void testCarParkDeleteCar_NotInList() {
        assertThrows(ArrayStoreException.class, () -> carPark.DeleteCar(car1));
    }

    @Test
    void testCarParkGetCarsCount() {
        carPark.AddCar(car1);
        carPark.AddCar(car2);
        assertEquals(2, carPark.GetCarsCount());
    }

    @Test
    void testCarParkGetCars_ReturnsCopy() {
        carPark.AddCar(car1);
        List<Car> cars = carPark.GetCars();
        cars.add(car2);
        assertEquals(1, carPark.GetCarsCount());
    }

    @Test
    void testCarParkEquals() {
        carPark.AddCar(car1);
        CarPark anotherCarPark = new CarPark();
        anotherCarPark.AddCar(car1);
        assertEquals(carPark, anotherCarPark);
    }

    @Test
    void testCarParkEquals_DifferentObjects() {
        carPark.AddCar(car1);
        CarPark anotherCarPark = new CarPark();
        anotherCarPark.AddCar(car2);
        assertNotEquals(carPark, anotherCarPark);
    }

    @Test
    void testCarParkHashCode_Consistency() {
        carPark.AddCar(car1);
        int hash1 = carPark.hashCode();
        int hash2 = carPark.hashCode();
        assertEquals(hash1, hash2);
    }
}
