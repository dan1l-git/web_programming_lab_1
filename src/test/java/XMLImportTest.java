import org.example.Car;
import org.example.CarPark;
import org.example.XMLImporter;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class XMLImportTest {
    @Test
    void testImportFromXml_ContentVerification() {
        // 1. Створюємо XML-рядок для тесту
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

        // 2. Створюємо InputStream з цього рядка
        ByteArrayInputStream inputStream = new ByteArrayInputStream(fakeXml.getBytes());

        // 3. Викликаємо імпорт
        CarPark importedCarPark = XMLImporter.ImportFromXml(inputStream);
        List<Car> cars = importedCarPark.getCars();

        // 4. Перевіряємо, що об'єкт імпортований правильно
        assertNotNull(importedCarPark, "Об'єкт не повинен бути null");
        assertEquals(1, importedCarPark.getCarsCount(), "Імпортоване ім'я має бути 'Test Park'");
        assertEquals("CH-R", cars.get(0).getModel());
    }

}
