import java.util.ArrayList;

public class PlanetSystem {
    private String name;
    private String centerStar;
    private ArrayList<Planet> planetList = new ArrayList<>();

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

    public void setName(String name) {
        this.name = name;
    }

    public String getCenterStar() {
        return centerStar;
    }

    public void setCenterStar(String centerStar) {
        this.centerStar = centerStar;
    }

    public ArrayList<Planet> getPlanetList() {
        return new ArrayList<>(planetList);
    }

    public void addPlanet(Planet aPlanet) {
        planetList.add(aPlanet);
    }

    public static void printPlanets(ArrayList<Planet> planetList) {

        for (Planet enPlanet : planetList) {
            System.out.println(enPlanet);
        }
    }

    public Planet getBigPlanet() {
        Planet bigPlanet = planetList.get(0);

        for(int i = 0; i < planetList.size(); i++) {
            if(bigPlanet.getRadius() < planetList.get(i).getRadius()) {
                bigPlanet = planetList.get(i);
            }
            else if(bigPlanet.getRadius() == planetList.get(i).getRadius()) {
                if((bigPlanet.getMass() < planetList.get(i).getMass())) {
                    bigPlanet = planetList.get(i);
                }
            }
        }
        return bigPlanet;
    }

    public Planet getSmallPlanet() {
        Planet smallPlanet = planetList.get(0);

        for(int i = 0; i < planetList.size(); i++) {
            if(smallPlanet.getRadius() > planetList.get(i).getRadius()) {
                smallPlanet = planetList.get(i);
            }
            else if(smallPlanet.getRadius() == planetList.get(i).getRadius()) {
                if((smallPlanet.getMass() > planetList.get(i).getMass())) {
                    smallPlanet = planetList.get(i);
                }
            }
        }
        return smallPlanet;
    }

    public void getPlanetBasedOnName(String input) {
        for(int i = 0; i < planetList.size(); i++) {
            if (input == planetList.get(i).getName()) {
                System.out.println(planetList.get(i));
            }
        }
    }

    @Override
    public String toString() {
        return "Planetsystem: " + getName() + ", CenterStar: " + getCenterStar() + " med sine " + planetList.size() + " planeter rundt seg";
    }

}
