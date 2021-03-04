package model;

public class Invertebrates extends Animals{
    private double quantityOfLegs;


    //Constructor
    public Invertebrates() {
    }

    public Invertebrates(String name, String scientificName, double quantityOfLegs) {
        super(name, scientificName);
        this.quantityOfLegs = quantityOfLegs;
    }


    //Get and set
    public double getQuantityOfLegs() {
        return quantityOfLegs;
    }

    public void setQuantityOfLegs(double quantityOfLegs) {
        this.quantityOfLegs = quantityOfLegs;
    }



    //toString
    @Override
    public String toString() {
        return String.format("[name=%s, scientific name=%s, quantity of legs=%.1f]", getName(), getScientificName(), quantityOfLegs);
    }
}
