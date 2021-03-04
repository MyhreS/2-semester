public class NaturalSatellite extends CelestialBody {
    private double semiMajorAxis;
    private double eccentricity ;
    private double orbitalPeriod;
    private double centralCelestialBody;
    private static final double AU = 149597871;
    private static final double G = 0.00000000006674;

    public NaturalSatellite(String name, double mass, double radius, double semiMajorAxis, double eccentricity, double orbitalPeriod) {
        super(name, mass, radius);
        this.semiMajorAxis = semiMajorAxis;
        this.eccentricity = eccentricity;
        this.orbitalPeriod = orbitalPeriod;
    }

    public NaturalSatellite(String name, double mass, double radius, double semiMajorAxis, double eccentricity, double orbitalPeriod, double centralCelestialBody) {
        super(name, mass, radius);
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

    public double getCentralCelestialBody() {
        return centralCelestialBody;
    }

    public void setCentralCelestialBody(double centralCelestialBody) {
        this.centralCelestialBody = centralCelestialBody;
    }

    public static double getAU() {
        return AU;
    }

    public static double getG() {
        return G;
    }

    @Override
    public String toString() {
        return getName() + " er en naturlig satellitt";
    }
}
