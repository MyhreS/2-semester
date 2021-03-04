import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        PlanetSystem theSun = new PlanetSystem("The sun", "Sun");
        Star sun = new Star("Sun", 1.9885E30, 695342, 5777);
        Planet mercury = new Planet("Mercury", 3.283E23, 2439.7);
        Planet venus = new Planet("Venus", 4.867E24, 6051.8);
        Planet earth = new Planet("Earth", 5.972E24, 6371);
        Planet mars = new Planet("Mars", 6.39E23, 3389.5);
        Planet jupiter = new Planet("Jupiter", 1.898E27, 69911);
        Planet saturn = new Planet("Saturn", 5.683E26, 58232);
        Planet uranus = new Planet("Uranus", 8.681E25, 25362);
        Planet neptune = new Planet("Neptune", 1.024E26, 24622);

        theSun.addPlanet(mercury);
        theSun.addPlanet(venus);
        theSun.addPlanet(earth);
        theSun.addPlanet(mars);
        theSun.addPlanet(jupiter);
        theSun.addPlanet(saturn);
        theSun.addPlanet(uranus);
        theSun.addPlanet(neptune);

        //theSun.printPlanets(theSun.getPlanetList());

        //Oppgave 2.3
        System.out.println(theSun + "\n" + mercury + "\n" + uranus);

        //Oppgave 2.4
        System.out.println(String.format("%s har masse i MJUP: %f og radius i RJUP: %f", saturn.getName(), saturn.getMassInMjup(), saturn.getRadiusInRjup()));
        System.out.println(String.format("%s har masse i MJUP: %f og radius i RJUP: %f", theSun.getName(), sun.getMassInMsun(), sun.getRadiusInRsun()));

        //Oppgave 2.5
        System.out.println(String.format("%s har gravitasjon på: %f", neptune.getName(), neptune.calcSurfaceGravity()));

        //Oppgave 2.6
        Planet largestPlanet = theSun.getBigPlanet();
        Planet smallestPlanet = theSun.getSmallPlanet();

        System.out.println(String.format("%s er den største planeten målt i radius: %f", largestPlanet.getName(), largestPlanet.getRadius()));
        System.out.println(String.format("%s er den minste planeten målt i radius: %f", smallestPlanet.getName(), smallestPlanet.getRadius()));


    }


}
