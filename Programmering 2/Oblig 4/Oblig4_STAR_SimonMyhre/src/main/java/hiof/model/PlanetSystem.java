package hiof.model;

import java.util.ArrayList;

public class PlanetSystem implements Comparable<PlanetSystem> {
    private String name;
    private Star centerStar;
    private ArrayList<Planet> planetList;
    private String pictureUrl;

    //Konstruktør
    public PlanetSystem(String name, Star centerStar, ArrayList<Planet> planetList, String pictureUrl) {
        this.name = name;
        this.centerStar = centerStar;
        this.planetList = planetList;
        this.pictureUrl = pictureUrl;
    }


    //Getter
    public String getName() {
        return name;
    }

    public Star getCenterStar() {
        return centerStar;
    }

    public ArrayList<Planet> getPlanetList() {
        return planetList;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }


    //Setter
    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlanetList(ArrayList<Planet> planetList) {
        this.planetList = planetList;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public void addPlanet(Planet aPlanet) {
        planetList.add(aPlanet);
    }



/*
    public void addPlanet(ArrayList<Planet> planetList) {
        this.planetList.addAll(planetList);
    }

    public ArrayList<Planet> getPlanetList() {
        return new ArrayList<>(planetList);
    }

 */
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

    public Planet getPlanetBasedOnName(Planet planet) {
        Planet placeholder = planet;
        for(int i = 0; i < planetList.size(); i++) {
            if(planet.getName() == planetList.get(i).getName()) {
                placeholder = planet;
            }
        }
        return placeholder;
    }

    @Override
    public String toString() {
        return "Solsystem" + name + ", CenterStar: " + centerStar + ", planeter: " + planetList;
    }

    @Override
    public int compareTo(PlanetSystem other) {
        if(this.planetList.size() < other.planetList.size()) {
            return -1;
        }
        else if(this.planetList.size() > other.planetList.size()) {
            return -1;
        }
        else return 0;
    }
}
