import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        PlanetSystem theSun = new PlanetSystem("The sun", "Sun");
        ArrayList<Planet> planeter = new ArrayList<Planet>();

        // Sola
        Star sun = new Star("Sun", 1.9885E30, 695342, 5777);

        // Arraylist planeter
        Planet mercury = new Planet("Mercury", 3.283E23, 2439.7); planeter.add(mercury);
        Planet venus = new Planet("Venus", 4.867E24, 6051.8); planeter.add(venus);
        Planet earth = new Planet("Earth", 5.972E24, 6371); planeter.add(earth);
        Planet mars = new Planet("Mars", 6.39E23, 3389.5); planeter.add(mars);
        Planet jupiter = new Planet("Jupiter", 1.898E27, 69911); planeter.add(jupiter);
        Planet saturn = new Planet("Saturn", 5.683E26, 58232); planeter.add(saturn);
        Planet uranus = new Planet("Uranus", 8.681E25, 25362); planeter.add(uranus);
        Planet neptune = new Planet("Neptune", 1.024E26, 24622); planeter.add(neptune);

        //Oppgave 2.1 til 2.3
        System.out.println("Oppgave 2.1 til 2.3 \n" );

        // print SolarSystem
        System.out.print(theSun);
        for (Planet p : planeter) {
            System.out.print(p.getName() + ", ");
        }
        //print Star
        System.out.println("\n" + sun);
        //print some planets
        System.out.println(planeter.get(0).toString().replace("[","").replace("]",""));
        System.out.println(planeter.get(1).toString().replace("[","").replace("]",""));
        System.out.println(planeter.get(2).toString().replace("[","").replace("]",""));

        //Oppgave 2.4
        System.out.println("\n \n Oppgave 2.4 \n" );

        System.out.println("Name: " + planeter.get(5).getName() + ", Mass in Mjup: " + Planet.getMassInMjup(planeter.get(5).getMass()) + ", Radius in Rjup: " + Planet.getRadiusInRjup(planeter.get(5).getRadius()));
        System.out.println("Name: " + sun.getName() + ", Mass in Msun: " + Star.getMassInMsun(sun.getMass()) + ", Radius in Rsun: " + Star.getRadiusInRsun(sun.getRadius()));


        //Oppgave 2.5
        System.out.println("\n \n Oppgave 2.5 \n");

        System.out.println("Name: " + planeter.get(7).getName() + ", Surface Gravity: " + Planet.calcSurfaceGravity(planeter.get(7).getMass(), planeter.get(7).getRadius()));

        //Oppgave 2.6
        System.out.println("\n \n Oppgave 2.6 \n");


        //Find largest planet
        String nameBiggestPlanet = ""; double valueBiggestPlanetMass = 0; double valueBiggestPlanetRadius = 0;
        for(int i = 0; i < planeter.size(); i++) {
            if (valueBiggestPlanetMass == planeter.get(i).getMass()) {
                if (valueBiggestPlanetRadius < planeter.get(i).getRadius()) {
                    nameBiggestPlanet = planeter.get(i).getName();
                    valueBiggestPlanetMass = planeter.get(i).getMass();
                    valueBiggestPlanetRadius = planeter.get(i).getRadius();
                }
            }

            else if(valueBiggestPlanetMass < planeter.get(i).getMass()) {
                nameBiggestPlanet = planeter.get(i).getName();
                valueBiggestPlanetMass = planeter.get(i).getMass();
                valueBiggestPlanetRadius = planeter.get(i).getRadius();
            }
        }

        //Find smallest planet
        String nameSmallestPlanet = "";  double valueSmallestPlanetMass = valueBiggestPlanetMass; double valueSmallestPlanetRadius = valueBiggestPlanetRadius;
        for(int i = 0; i < planeter.size(); i++) {
            if (valueSmallestPlanetMass == planeter.get(i).getMass()) {
                if (valueSmallestPlanetRadius > planeter.get(i).getRadius()) {
                    nameSmallestPlanet = planeter.get(i).getName();
                    valueSmallestPlanetMass = planeter.get(i).getMass();
                    valueSmallestPlanetRadius = planeter.get(i).getRadius();
                }
            }

            else if(valueSmallestPlanetMass > planeter.get(i).getMass()) {
                nameSmallestPlanet = planeter.get(i).getName();
                valueSmallestPlanetMass = planeter.get(i).getMass();
                valueSmallestPlanetRadius = planeter.get(i).getRadius();
            }
        }

        System.out.println("Largest planet: " + nameBiggestPlanet  + ", mass: " + valueBiggestPlanetMass + ", radius: "  + valueBiggestPlanetRadius);
        System.out.println("Smallest planet: " + nameSmallestPlanet  + ", mass: " + valueSmallestPlanetMass + ", radius: "  + valueSmallestPlanetRadius);
    }


}
