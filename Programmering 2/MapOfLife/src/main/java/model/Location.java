package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Location implements Comparable<Location>{
    private String name;
    private double latitude;
    private double longitude;
    private Planet planet;
    private ArrayList<Biom> biomArrayList = new ArrayList<Biom>();


    //Constructor
    public Location() {
    }

    public Location(String name) {
        this.name = name;
    }

    public Location(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location(String name, double latitude, double longitude, Planet planet) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.planet = planet;
    }

    public Location(String name, double latitude, double longitude, Planet planet, ArrayList<Biom> biomArrayList) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.planet = planet;
        this.biomArrayList = biomArrayList;
    }


    //Methods
    @JsonIgnore
    public void addBiom(Biom biom) {
        biomArrayList.add(biom);
    }

    @JsonIgnore
    public void removeBiom(Biom biom) {
        biomArrayList.remove(biom);
    }


    //Get and set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public ArrayList<Biom> getBiomArrayList() {
        return biomArrayList;
    }

    public void setBiomArrayList(ArrayList<Biom> biomArrayList) {
        this.biomArrayList = biomArrayList;
    }


    //toString
    @Override
    public String toString() {
        return String.format("[name=%s, latitude=%.0f, longitude=%.0f, planet=%s, biom=%s]",name, latitude, longitude, planet, biomArrayList);
    }


    //compareTo
    @Override
    public int compareTo(@NotNull Location l) {
        if(this.latitude > l.getLatitude()) {
            return 1;
        }
        else if(this.latitude < l.getLatitude()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
