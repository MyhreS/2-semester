package hiof.model;

public abstract class CelestialBody implements Comparable<Planet>{
    private String name;
    private double mass;
    private double radius;
    private String pictureUrl;

    public CelestialBody(String name, double mass, double radius, String pictureUrl) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
        this.pictureUrl = pictureUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public double getRadiusInMeter() {
        return getRadius() * 1000;
    }

    @Override
    public String toString() {
        return getName() + " er et himmellegeme";
    }

    @Override
    public int compareTo(Planet other) {
        if(getRadius() > other.getRadius()) {
            return -1;
        }
        else if(getRadius() < other.getRadius()) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
