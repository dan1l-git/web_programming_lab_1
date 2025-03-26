package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class XMLImporter {
    public static CarPark ImportFromXml(InputStream inputStream) {
        try {
            JAXBContext context = JAXBContext.newInstance(CarPark.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (CarPark) unmarshaller.unmarshal(inputStream);
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static CarPark ImportFromXml(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            return ImportFromXml(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
