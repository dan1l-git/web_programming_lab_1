package org.example;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.Objects;

@XmlRootElement
public class Manufacturer {
    private String name;
    private String country;


    public Manufacturer() {}
    public Manufacturer(String name, String country) {
        if(name.isBlank()){throw new IllegalArgumentException("Name cannot be blank.");}
        if(country.isBlank()){throw new IllegalArgumentException("Country cannot be blank.");}
        this.name = name;
        this.country = country;
    }

    // get; set;
    @XmlElement(name = "ManufactureR")
    public String getName() {return name;}
    public void setName(String name) {
        if(name.isBlank()){throw new IllegalArgumentException("Name cannot be blank.");}
        else{this.name = name;}
    }
    @XmlElement
    public String getCountry() {return country;}
    public void setCountry(String country) {
        if(country.isBlank()){throw new IllegalArgumentException("Country cannot be blank.");}
        else{this.country = country;}
    }

    @Override
    public String toString() {
        return "Manufacturer name: " + name + ", country: " + country;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Manufacturer other)) return false;

        return Objects.equals(name, other.name) && Objects.equals(country, other.country);
    }
}
