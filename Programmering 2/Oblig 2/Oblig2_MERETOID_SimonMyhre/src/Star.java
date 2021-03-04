public class Star extends PlanetSystem  {
    private double mass;
    private double radius;
    private double effectiveTemp;

    public Star(String name, double mass, double radius, double effectiveTemp) {
        super(name);
        this.mass = mass;
        this.radius = radius;
        this.effectiveTemp = effectiveTemp;
    }

    public Star(String name, double mass, double radius) {
        super(name);
        this.mass = mass;
        this.radius = radius;
    }

    public static double getMassInMsun(double mass) {
        return (mass)/(1.9885E30);
    }

    public static double getRadiusInRsun(double radius) {
        return (radius)/695700;
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    public double getEffectiveTemp() {
        return effectiveTemp;
    }

    @Override
    public String toString() {
        return "Star: " + getName() + ", Mass(kg): " + getMass() + ", Radius(km): " + getRadius() + ", Effective temperature: " + getEffectiveTemp();
    }
}
