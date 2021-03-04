public class Planet extends NaturalSatellite {
    private static final double MJUP = 1.898E27;
    private static final double RJUP = 71492;

    public Planet(String name, double mass, double radius, double semiMajorAxis, double eccentricity, double orbitalPeriod) {
        super(name, mass, radius, semiMajorAxis, eccentricity, orbitalPeriod);
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

    public double distanceToCentralBody(double degrees) {
        return ((getSemiMajorAxis()*(1-Math.pow(getEccentricity(), 2)))/(1+getEccentricity()*Math.cos(Math.toRadians(degrees)))*getAU());
    }

    public double orbitingVelocity(double distance) {
        return (Math.sqrt((getG() * 1.9885E30) / (distance * 1000))) / 1000;
    }


    @Override
    public String toString() {
        return getName() + " har en radius på: " + getRadius() + "km og masse på: " + getMass()  + "kg";
    }
}
