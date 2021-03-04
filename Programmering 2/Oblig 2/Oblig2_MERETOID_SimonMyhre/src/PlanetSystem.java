public class PlanetSystem {
    private String name;
    private String centerStar;

    public PlanetSystem(String name, String centerStar) {
        this.name = name;
        this.centerStar = centerStar;
    }

    public PlanetSystem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCenterStar() {
        return centerStar;
    }

    @Override
    public String toString() {
        return "Solar system: " + getName() + ", Center star: " + getCenterStar() + ", planets: ";
    }
}
