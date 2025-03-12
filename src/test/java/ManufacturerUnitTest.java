import org.example.Manufacturer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ManufacturerUnitTest {

    @Test
    void testManufacturerEmptyNameCreation(){
        assertThrows(IllegalArgumentException.class, () -> new Manufacturer(" ", "Japan"));
    }

    @Test
    void testManufacturerEmptyCountryCreation(){
        assertThrows(IllegalArgumentException.class, () -> new Manufacturer("Toyota", ""));
    }

    @Test
    void testManufacturerEquals(){
        Manufacturer manufacturer1 = new Manufacturer("Toyota", "Japan");
        Manufacturer manufacturer2 = new Manufacturer("Toyota", "Japan");
        assertEquals(manufacturer1, manufacturer2);
    }

    @Test
    void testManufacturerHashCode(){
        Manufacturer manufacturer1 = new Manufacturer("Toyota", "Japan");
        Manufacturer manufacturer2 = new Manufacturer("Toyota", "Japan");
        assertEquals(manufacturer1.hashCode(), manufacturer2.hashCode());
    }
}
