package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.List;

public class XMLImporter {
    public static CarPark importFromXml(File file) throws JAXBException {
        //File file = new File("CarPark.xml");
        JAXBContext context = JAXBContext.newInstance(Manufacturer.class,Car.class, CarPark.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (CarPark) unmarshaller.unmarshal(file);

    }
}
