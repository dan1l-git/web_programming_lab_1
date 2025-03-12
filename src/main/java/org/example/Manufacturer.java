package org.example;

import java.util.Objects;

public class Manufacturer {
    private String name;
    private String country;

    public Manufacturer(String name, String country) {
        this.name = name;
        this.country = country;
    }

    // get; set;
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getCountry() {return country;}
    public void setCountry(String country) {this.country = country;}

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
