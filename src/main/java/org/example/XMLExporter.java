package org.example;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.JAXBContext;
public class XMLExporter {

    public static void ExportToXml(CarPark carPark, OutputStream outputStream) {
        try {
            JAXBContext context = JAXBContext.newInstance(Manufacturer.class, Car.class, CarPark.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(carPark, outputStream);
            System.out.println("Data successfully exported to OutputStream");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    public static void ExportToXml(CarPark carPark, String filePath){
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            ExportToXml(carPark, fos);
            System.out.println("Data successfully exported to: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
