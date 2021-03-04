public class Planet extends Star {

    public Planet(String name, double mass, double radius) {
        super(name, mass, radius);
    }

    public static double getMassInMjup(double mass) {
        return (mass)/(1.898E27);
    }

    public static double getRadiusInRjup(double radius) {
        return (radius)/71492;
    }

    public static double calcSurfaceGravity(double mass, double radius) {
        return (0.00000000006674 * mass)/(Math.pow(radius, 2));
    }

    @Override
    public String toString() {
        return "Planet: " + getName() + ", Mass(kg): " + getMass() + ", Radius(km): " + getRadius();
    }
}
