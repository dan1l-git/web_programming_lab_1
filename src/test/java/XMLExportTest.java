import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.example.Car;
import org.example.CarPark;
import org.example.Manufacturer;
import org.example.XMLExporter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

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

}
