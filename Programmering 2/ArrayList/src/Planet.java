public class Planet extends PlanetSystem {
    private double mass;
    private double radius;

    public Planet(String name, double mass, double radius) {
        super(name);
        this.mass = mass;
        this.radius = radius;
    }

    public double getMassInMjup() {
        return mass/(1.898E27);
    }

    public double getRadiusInRjup() {
        return radius/71492;
    }

    public double calcSurfaceGravity() {
        return ((6.67408E-11 * mass)/(Math.pow(getRadiusInMeter(), 2)));
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

    public double getRadiusInMeter() {
        return radius * 1000;
    }

    @Override
    public String toString() {
        return getName() + " har en radius på: " + getRadius() + "km og masse på: " + getMass()  + "kg";
    }
}
