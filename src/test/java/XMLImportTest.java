import org.example.Car;
import org.example.CarPark;
import org.example.Manufacturer;
import org.example.XMLImporter;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class XMLImportTest {
    @Test
    void testImportFromXml_ContentVerification() {
        String fakeXml = """
                <carPark>
                    <cars>
                        <fuelLevel>30.0</fuelLevel>
                        <manufacturer>
                            <country>Japan</country>
                            <ManufactureR>honda</ManufactureR>
                        </manufacturer>
                        <mileage>30</mileage>
                        <model>CH-R</model>
                    </cars>
                    <carsCount>1</carsCount>
                </carPark>
                """;


        ByteArrayInputStream inputStream = new ByteArrayInputStream(fakeXml.getBytes());

        Manufacturer mockManufacturer = mock(Manufacturer.class);
        when(mockManufacturer.getName()).thenReturn("honda");
        when(mockManufacturer.getCountry()).thenReturn("Japan");

        Car mockCar = mock(Car.class);
        when(mockCar.getModel()).thenReturn("CH-R");
        when(mockCar.getManufacturer()).thenReturn(mockManufacturer);
        when(mockCar.getFuelLevel()).thenReturn(30.0);

        List <Car> mockCars = new ArrayList<>();
        mockCars.add(mockCar);

        CarPark importedCarPark = mock(CarPark.class);
        when(importedCarPark.GetCars()).thenReturn(mockCars);
        when(importedCarPark.GetCarsCount()).thenReturn(1);

        List<Car> cars = importedCarPark.GetCars();
        assertNotNull(cars);
        assertEquals(1, cars.size());
        assertEquals(mockCar, cars.get(0));

        XMLImporter.ImportFromXml(inputStream);

        assertNotNull(importedCarPark, "Об'єкт не повинен бути null");
        assertEquals(1, importedCarPark.GetCarsCount(), "Має бути імпортована 1 машина'");
        assertEquals("CH-R", cars.get(0).getModel(), "Помилка імпорту, модель не співпадає");
    }

}
