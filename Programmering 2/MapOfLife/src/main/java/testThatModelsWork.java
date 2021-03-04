import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import model.*;

public class testThatModelsWork {

    public static void main(String[] args) {

        //Location ---------
        Planet earth = new Planet("Earth");
        ArrayList<Biom> bioms = new ArrayList<>();
        Biom sand = new Biom("Sand");
        Biom hav = new Biom("Hav");
        bioms.add(sand);
        bioms.add(hav);
        Location locationEarth = new Location("Fant et dyr", 1, 2, earth, bioms);

        System.out.println(locationEarth);


        //Animals ------------
        System.out.println("\n");
        Birds sparrow = new Birds("Spurv", "Fuglensensis", 4);

        System.out.println(sparrow);


        //Observation --------
        System.out.println("\n");
        Observation number1Observation = new Observation(1, "Fugl på mars", sparrow, LocalDate.now(), 1, "http", locationEarth, "Noe tekst");

        System.out.println(number1Observation);


        //Sort Observation ----------------
        System.out.println("\n");
        Observation number2Observation = new Observation(2, "Elg på mars", sparrow, LocalDate.now(), 1, "http", locationEarth, "Noe tekst");
        Observation number3Observation = new Observation(3, "Ulv på mars", sparrow, LocalDate.now(), 1, "http", locationEarth, "Noe tekst");
        ArrayList<Observation> observations = new ArrayList<>();
        observations.add(number1Observation);
        observations.add(number3Observation);
        observations.add(number2Observation);

        Collections.sort(observations);

        for(Observation o : observations) {
            System.out.println(o);
        }


        //Sort Location ----------------
        System.out.println("\n");
        Location locationMars = new Location("Fant en engel", 4, 2, earth, bioms);
        Location locationJupiter = new Location("Fant en fulg", 2, 3, earth, bioms);
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(locationEarth);
        locations.add(locationMars);
        locations.add(locationJupiter);

        Collections.sort(locations);


        for(Location l : locations) {
            System.out.println(l);
        }


        //Sort Animals -----------------
        System.out.println("\n");
        Invertebrates wolf = new Invertebrates("Ulv", "Ulvi", 4);
        Amphibians elf = new Amphibians("Alv", "Alvi", 2);
        ArrayList<Animals> animals = new ArrayList<>();
        animals.add(sparrow);
        animals.add(wolf);
        animals.add(elf);


        Collections.sort(animals);

        for(Animals a : animals) {
            System.out.println(a);
        }
    }
}
