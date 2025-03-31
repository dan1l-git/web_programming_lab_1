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
        //Створюємо XML-рядок для тесту
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

        //Створюємо InputStream з цього рядка
        ByteArrayInputStream inputStream = new ByteArrayInputStream(fakeXml.getBytes());

        //Викликаємо імпорт
        CarPark importedCarPark = XMLImporter.ImportFromXml(inputStream);
        List<Car> cars = importedCarPark.getCars();

        //Перевіряємо, що об'єкт імпортований правильно
        assertNotNull(importedCarPark, "Об'єкт не повинен бути null");
        assertEquals(1, importedCarPark.getCarsCount(), "Має бути імпортована 1 машина'");
        assertEquals("CH-R", cars.get(0).getModel(), "Помилка імпорту, модель не співпадає");
    }

}
