import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        PlanetSystem theSun = new PlanetSystem("The sun", "Sun");
        Star sun = new Star("Sun", 1.9885E30, 695342, 5777);


        Planet mercury = new Planet("Mercury", 3.283E23, 2439.7, 0.387, 0.206, 88);
        Planet venus = new Planet("Venus", 4.867E24, 6051.8, 0.723, 0.007, 225);
        Planet earth = new Planet("Earth", 5.972E24, 6371, 1, 0.017, 365);
        Planet mars = new Planet("Mars", 6.39E23, 3389.5, 1.524, 0.093, 687);
        Planet jupiter = new Planet("Jupiter", 1.898E27, 69911, 5.20440, 0.049, 4380);
        Planet saturn = new Planet("Saturn", 5.683E26, 58232, 9.5826, 0.057, 10585);
        Planet uranus = new Planet("Uranus", 8.681E25, 25362, 19.2184, 0.046, 30660);
        Planet neptune = new Planet("Neptune", 1.024E26, 24622, 30.11, 0.010, 60225);

        theSun.addPlanet(mercury);
        theSun.addPlanet(venus);
        theSun.addPlanet(earth);
        theSun.addPlanet(mars);
        theSun.addPlanet(jupiter);
        theSun.addPlanet(saturn);
        theSun.addPlanet(uranus);
        theSun.addPlanet(neptune);

        /*
        //Oppgave 2.3
        System.out.println(theSun + "\n" + mercury + "\n" + uranus);


        //Oppgave 2.4
        System.out.println(String.format("%s har masse i MJUP: %f og radius i RJUP: %f", saturn.getName(), saturn.getMassInMjup(), saturn.getRadiusInRjup()));
        System.out.println(String.format("%s har masse i Msun: %f og radius i Rsun: %f", sun.getName(), sun.getMassInMsun(), sun.getRadiusInRsun()));

        //Oppgave 2.5
        System.out.println(String.format("%s har gravitasjon på: %f", neptune.getName(), neptune.calcSurfaceGravity()));

        //Oppgave 2.6
        Planet largestPlanet = theSun.getBigPlanet();
        Planet smallestPlanet = theSun.getSmallPlanet();

        System.out.println(String.format("%s er den største planeten målt i radius: %f", largestPlanet.getName(), largestPlanet.getRadius()));
        System.out.println(String.format("%s er den minste planeten målt i radius: %f", smallestPlanet.getName(), smallestPlanet.getRadius()));


         */

        System.out.println("\n Oppgave 2.2 \n");

        //Oppgave 2.2 Oblig 3
        theSun.getPlanetBasedOnName("Mars");

        //Oppgave 2.5 og 2.6

        System.out.println("\n Oppgave 2.5/2.6 \n");

        for(int i = 0; i <= 360; i+= 90) {
            int converter = (int)earth.distanceToCentralBody(i);
            System.out.println(String.format("Earth has a distance of " + converter  + "km to the Sun at " + i + " degrees"));
            System.out.println(String.format("At a distance of %skm Earth has a velocity of %.2fkm/h \n", converter, earth.orbitingVelocity(converter)));
        }
    }
}
