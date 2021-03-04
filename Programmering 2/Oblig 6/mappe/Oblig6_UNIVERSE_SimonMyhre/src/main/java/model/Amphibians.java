package model;

public class Amphibians extends Animals{
    private double quantityOfEggs;


    //Constructor
    public Amphibians() {
    }

    public Amphibians(String name, String scientificName, double quantityOfEggs) {
        super(name, scientificName);
        this.quantityOfEggs = quantityOfEggs;
    }


    //Get and set
    public double getQuantityOfEggs() {
        return quantityOfEggs;
    }

    public void setQuantityOfEggs(double quantityOfEggs) {
        this.quantityOfEggs = quantityOfEggs;
    }


    //toString
    @Override
    public String toString() {
        return String.format("[name=%s, scientific name=%s, quantity of eggs=%.1f]", getName(), getScientificName(), quantityOfEggs);
    }
}
