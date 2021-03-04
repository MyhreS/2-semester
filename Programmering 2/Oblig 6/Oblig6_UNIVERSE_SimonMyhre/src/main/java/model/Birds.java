package model;

public class Birds extends Animals{
    private double wingspan;


    //Constructor
    public Birds() {
    }

    public Birds(String name, String scientificName, double wingspan) {
        super(name, scientificName);
        this.wingspan = wingspan;
    }


    //Get and set
    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }


    //toString
    @Override
    public String toString() {
        return String.format("[name=%s, scientific name=%s, winspan=%.1f]", getName(), getScientificName(), wingspan);
    }
}
