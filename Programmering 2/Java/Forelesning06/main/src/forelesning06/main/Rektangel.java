package forelesning06.main;

public class Rektangel extends Figur {
    private double side1;
    private double side2;

    public Rektangel(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double areal() {
        return side1 * side2;
    }

    @Override
    public double omkrets() {
        return 2*side1 + 2*side2;
    }

    @Override
    public String toString() {
        return "Rektangel med siden " + side1 + " " + side2;
    }
}
