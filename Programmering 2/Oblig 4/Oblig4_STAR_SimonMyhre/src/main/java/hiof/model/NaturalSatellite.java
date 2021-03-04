package hiof.model;

public class NaturalSatellite extends CelestialBody {
    private double semiMajorAxis;
    private double eccentricity ;
    private double orbitalPeriod;
    private CelestialBody centralCelestialBody;
    private static final double AU = 149597871;
    private static final double G = 0.00000000006674;

    public NaturalSatellite(String name, double mass, double radius, double semiMajorAxis, double eccentricity, double orbitalPeriod, String pictureUrl) {
        super(name, mass, radius, pictureUrl);
        this.semiMajorAxis = semiMajorAxis;
        this.eccentricity = eccentricity;
        this.orbitalPeriod = orbitalPeriod;
    }

    public NaturalSatellite(String name, double mass, double radius, double semiMajorAxis, double eccentricity, double orbitalPeriod, CelestialBody centralCelestialBody, String bildeURL) {
        super(name, mass, radius, bildeURL);
        this.semiMajorAxis = semiMajorAxis;
        this.eccentricity = eccentricity;
        this.orbitalPeriod = orbitalPeriod;
        this.centralCelestialBody = centralCelestialBody;
    }

    public double getSemiMajorAxis() {
        return semiMajorAxis;
    }

    public void setSemiMajorAxis(double semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }

    public double getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(double eccentricity) {
        this.eccentricity = eccentricity;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(double orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public CelestialBody getCentralCelestialBody() {
        return centralCelestialBody;
    }

    public void setCentralCelestialBody(CelestialBody centralCelestialBody) {
        this.centralCelestialBody = centralCelestialBody;
    }

    public static double getAU() {
        return AU;
    }

    public static double getG() {
        return G;
    }

    public double distanceToCentralBody(double degrees) {
        return ((getSemiMajorAxis()*(1-Math.pow(getEccentricity(), 2)))/(1+getEccentricity()*Math.cos(Math.toRadians(degrees)))*getAU());
    }

    public double orbitingVelocity(double distance) {
        return (Math.sqrt((getG() * 1.9885E30) / (distance * 1000))) / 1000;
    }

    @Override
    public String toString() {
        return getName() + " er en naturlig satellitt";
    }
}
