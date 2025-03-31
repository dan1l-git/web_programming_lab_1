import org.example.Car;
import org.example.CarPark;
import org.example.Manufacturer;
import org.example.XMLExporter;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class XMLExportTest {

    @Test
    void TestXMLExport() throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        CarPark testCarPark = new CarPark();
        Manufacturer honda = new Manufacturer("honda", "Japan");
        Car car1 = new Car("Civic", honda, 50);
        Car car2 = new Car("CH-R", honda, 60);
        Car car3 = new Car("Accord", honda, 60);
        testCarPark.AddCar(car1);
        testCarPark.AddCar(car2);
        testCarPark.AddCar(car3);

        XMLExporter.ExportToXml(testCarPark, outputStream);

        String xmlOutput = outputStream.toString();

        assertTrue(xmlOutput.contains("<carPark>"), "XML має містити кореневий елемент <carPark>");
        assertTrue(xmlOutput.contains("<fuelLevel>60.0</fuelLevel>"), "XML має містити інформацію про кількість пального 60 літрів");

        outputStream.close();
    }
@Test
void TestXMLExport_Mock() throws Exception {

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    CarPark mockCarPark = mock(CarPark.class);

    XMLExporter.ExportToXml(mockCarPark, outputStream);
    String xmlOutput = outputStream.toString();

    assertTrue(xmlOutput.contains("<carPark>"), "XML має містити кореневий елемент <carPark>");
    assertTrue(xmlOutput.contains("<carsCount>0</carsCount>"), "XML не містить потрібних тегів");

    outputStream.close();
}

}
