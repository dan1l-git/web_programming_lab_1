import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import org.example.Car;
import org.example.CarPark;
import org.example.Manufacturer;
import org.example.XMLExporter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
public class XMLExportTest {

    @Test
    void TestXMLExport() throws Exception {
        //mock the file
//        File mockFile = mock(File.class);
//        FileOutputStream mockOutputStream = mock(FileOutputStream.class);
//
//        when(mockFile.getAbsolutePath()).thenReturn("mocked_path.xml");
//        doNothing().when(mockOutputStream).write(any(byte[].class));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        CarPark testCarPark = new CarPark();
        Manufacturer honda = new Manufacturer("honda", "Japan");
        Car car1 = new Car("Civic", honda, 50);
        Car car2 = new Car("CH-R", honda, 60);
        Car car3 = new Car("Accord", honda, 60);
        testCarPark.addCar(car1);
        testCarPark.addCar(car2);
        testCarPark.addCar(car3);

        XMLExporter.ExportToXml(testCarPark, outputStream);

        JAXBContext context = JAXBContext.newInstance(CarPark.class, Manufacturer.class, Car.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        outputStream.close();
    }

    @Test
    void TestXMLExport_ContentVerification() throws Exception {
        CarPark testCarPark = new CarPark();
        Manufacturer honda = new Manufacturer("honda", "Japan");
        Car car1 = new Car("Civic", honda, 50);
        Car car2 = new Car("CH-R", honda, 60);
        Car car3 = new Car("Accord", honda, 60);
        testCarPark.addCar(car1);
        testCarPark.addCar(car2);
        testCarPark.addCar(car3);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        XMLExporter.ExportToXml(testCarPark, outputStream);

        String xmlContent = outputStream.toString();

        assertTrue(xmlContent.contains("<carPark>"), "XML має містити кореневий тег <CarPark>");

        // 6. Закриваємо потік
        outputStream.close();
    }

}
