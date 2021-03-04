public class Star extends CelestialBody {
    private double effectiveTemp;
    private static final double MSUN = 1.9885E30;
    private static final double RSUN = 695700;

    public Star(String name, double mass, double radius, double effectiveTemp) {
        super(name, mass, radius);
        this.effectiveTemp = effectiveTemp;
    }

    public double getMassInMsun() {
        return getMass()/(MSUN);
    }

    public double getRadiusInRsun() {
        return getRadius()/RSUN;
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
