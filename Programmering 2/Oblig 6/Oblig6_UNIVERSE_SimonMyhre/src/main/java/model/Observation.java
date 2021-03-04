package model;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class Observation implements Comparable<Observation> {
    private double id;
    private String name;
    private Animals animal;
    private LocalDate date;
    private double quantity;
    private String pictureUrl;
    private String text;
    private Location location;


    //Constructor
    public Observation() {
    }

    public Observation(double id, String name, LocalDate date, double quantity, String pictureUrl, String text) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.quantity = quantity;
        this.pictureUrl = pictureUrl;
        this.text = text;
    }

    public Observation(double id, String name, Animals animal, LocalDate date, double quantity, String pictureUrl, Location location, String text) {
        this.id = id;
        this.name = name;
        this.animal = animal;
        this.date = date;
        this.quantity = quantity;
        this.pictureUrl = pictureUrl;
        this.text = text;
        this.location = location;
    }


    //Get and set
    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animals getAnimal() {
        return animal;
    }

    public void setAnimal(Animals animal) {
        this.animal = animal;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    //toString
    @Override
    public String toString() {
        return String.format("Observation: id=%.0f, name=%s, animals=%s, location=%s, date=%tF, quantity=%.0f, pictureUrl=%s, text=%s",id, name, animal, location, date, quantity, pictureUrl, text);
    }


    //compareTo
    @Override
    public int compareTo(@NotNull Observation o) {
        if(this.id > o.getId()) {
            return 1;
        }
        else if(this.id < o.getId()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
