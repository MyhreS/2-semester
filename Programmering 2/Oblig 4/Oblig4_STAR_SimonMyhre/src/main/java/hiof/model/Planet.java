package hiof.model;

public class Planet extends NaturalSatellite {
    private static final double MJUP = 1.898E27;
    private static final double RJUP = 71492;

    public Planet(String name, double mass, double radius, double semiMajorAxis, double eccentricity, double orbitalPeriod, CelestialBody centralCelestialBody, String pictureUrl) {
        super(name, mass, radius, semiMajorAxis, eccentricity, orbitalPeriod, centralCelestialBody, pictureUrl);
    }

    public double getMassInMjup() {
        return getMass()/(MJUP);
    }

    public double getRadiusInRjup() {
        return getRadius()/RJUP;
    }

    public double calcSurfaceGravity() {
        return ((6.67408E-11 * getMass())/(Math.pow(getRadiusInMeter(), 2)));
    }

    @Override
    public String toString() {
        return getName() + " har en radius på: " + getRadius() + "km og masse på: " + getMass()  + "kg";
    }
}
