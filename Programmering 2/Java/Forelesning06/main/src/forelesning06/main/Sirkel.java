package forelesning06.main;

public class Sirkel extends Figur{
    private double radius;

    public Sirkel(double radius) {
        this.radius = radius;
    }

    public double beregnDiameter() {
        return 2*radius;
    }

    @Override
    public double areal() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double omkrets() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Sirkelen har radius " + radius + " og diameter " + beregnDiameter();
    }


}
