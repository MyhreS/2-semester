public class Star extends PlanetSystem {
    private double mass;
    private double radius;
    private double effectiveTemp;

    public Star(String name, double mass, double radius, double effectiveTemp) {
        super(name);
        this.mass = mass;
        this.radius = radius;
        this.effectiveTemp = effectiveTemp;
    }

    public double getMassInMsun() {
        return mass/(1.9885E30);
    }

    public double getRadiusInRsun() {
        return radius/695700;
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

    public double getEffectiveTemp() {
        return effectiveTemp;
    }

    public void setEffectiveTemp(double effectiveTemp) {
        this.effectiveTemp = effectiveTemp;
    }

    @Override
    public String toString() {
        return getName() + "!";
    }
}
