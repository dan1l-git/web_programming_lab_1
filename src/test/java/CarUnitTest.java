import org.example.Car;
import org.example.Manufacturer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarUnitTest {
    private Manufacturer toyota;
    private Car car;

    @BeforeEach
    void setUp() {
        toyota = new Manufacturer("Toyota", "Japan");
        car = new Car("Corolla", toyota, 50);
    }

    //driving tests
    @Test
    void testDriveSuccess(){
        String result = car.drive(100, 0.5);
        assertEquals("Driving 100 kilometers", result);
        assertEquals(50-(100*0.5), car.getFuelLevel());
        assertEquals(100, car.getMileage());
    }

    @Test
    void testDriveNotEnoughFuel(){
        String result = car.drive(500, 0.5);
        assertEquals("Not enough fuel to drive 500 kilometers", result);
        assertEquals(50, car.getFuelLevel());
        assertEquals(0, car.getMileage());
    }

    @Test
    void testDriveNegativeDistance(){
        assertThrows(IllegalArgumentException.class, ()->car.drive(-100,0.5));
    }

    //refuel tests
    @Test
    void testRefuelSuccess(){
        car.drive(50,0.5);
        car.refuel(10);
        assertEquals(50-25+10, car.getFuelLevel());
    }

    @Test
    void testRefuelOverflow(){
        car.refuel(100);
        assertEquals(50, car.getFuelLevel());
    }

    @Test
    void testRefuelNegativeAmount(){
        assertThrows(IllegalArgumentException.class, ()->car.refuel(-100));
    }

    //creation tests
    @Test
    void testCarCreationNegativeFuelCapacity(){
        assertThrows(IllegalArgumentException.class, ()-> new Car("Corolla", toyota, -10));
    }

    @Test
    void testCarCreationBlankModel(){
        assertThrows(IllegalArgumentException.class, ()-> new Car("", toyota, 10));
    }

    @Test
    void testCarEquals(){
        Car car1 = new Car("Corolla", toyota, 50);
        Car car2 = new Car("Corolla", toyota, 50);
        assertEquals(car1, car2);
    }

    @Test
    void testCarHashCode(){
        Car car1 = new Car("Corolla", toyota, 50);
        Car car2 = new Car("Corolla", toyota, 50);
        assertEquals(car1.hashCode(), car2.hashCode());
    }
}
