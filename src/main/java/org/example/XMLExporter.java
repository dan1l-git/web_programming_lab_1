package org.example;
import java.io.File;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.JAXBContext;
public class XMLExporter {
    public static void ExportToXml(CarPark carPark, String filePath){
        try{
            JAXBContext context = JAXBContext.newInstance(Manufacturer.class, Car.class, CarPark.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(carPark, new File(filePath));
            System.out.println("Data successfully exported to: " + filePath);
        }catch(JAXBException e){
            e.printStackTrace();
        }
    }

}
