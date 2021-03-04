import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import controller.MapOfLifeController;
import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.VueComponent;
import model.*;
import repository.MapOfLifeRepository;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        //Planets, bioms and animals
        Planet earth = new Planet("Earth");
        Planet mars = new Planet("Mars");
        Planet jupiter = new Planet("Jupiter");
        Biom desert = new Biom("Desert");
        Biom ocean = new Biom("Ocean");
        Biom tundra = new Biom("Tundra");
        Biom mountain = new Biom("Mountains");
        Birds sparrow = new Birds("Sparrow", "Sparrowsis", 4);
        Amphibians wolf = new Amphibians("Wolf", "Wolfsis", 1);
        Birds duck = new Birds("Duck", "Ducksis", 2);
        Invertebrates dog = new Invertebrates("Dog", "Dogsis", 2);
        Invertebrates cat = new Invertebrates("Cat", "Catsis", 3);
        Amphibians snake = new Amphibians("Snake", "Snakesis", 0);

        //Locations
        Location locationEarth = new Location("On Earth", 40, 12, earth);
        locationEarth.addBiom(desert);
        locationEarth.addBiom(ocean);

        Location locationMars = new Location("On Mars", 11, 2, mars);
        locationMars.addBiom(tundra);
        locationMars.addBiom(mountain);
        locationMars.addBiom(desert);

        Location locationJupiter = new Location("On Jupiter", 111, 645, jupiter);
        locationJupiter.addBiom(mountain);

        //Observation
        List<Observation> list = new ArrayList<>();
        Observation nr1 = new Observation(1, "Bird", sparrow, LocalDate.now(), 1, "http", locationEarth, "Look at this!");
        Observation nr2 = new Observation(2, "Amphibian", wolf, LocalDate.now(), 6, "http", locationJupiter, "Sometime you have to look at this!");
        Observation nr3 = new Observation(3, "Bird", duck, LocalDate.now(), 2, "http", locationMars, "Dont look at this!");
        Observation nr4 = new Observation(4, "Invertebrate", dog, LocalDate.now(), 11, "http", locationEarth, "Maybe look at this!");
        Observation nr5 = new Observation(5, "Invertebrate", cat, LocalDate.now(), 2, "http", locationMars, "Never look at this!");
        Observation nr6 = new Observation(6, "Amphibian", snake, LocalDate.now(), 6, "http", locationJupiter, "Never ever look at this!");
        list.add(nr1);
        list.add(nr2);
        list.add(nr3);
        list.add(nr4);
        list.add(nr5);
        list.add(nr6);

        System.out.println(list);
        /*


        //Add repository to be able to run methods
        MapOfLifeRepository mapOfLifeRepository = new MapOfLifeRepository("mapoflife.json");


        //Create new observation--------------------
        Observation nr8 = new Observation(8, "Amphibian", snake, LocalDate.now(), 6, "http", locationJupiter, "Never ever look at this!");
        mapOfLifeRepository.createObservation(nr8);


        //Delete observation ------------------------------
        mapOfLifeRepository.deleteObservation(6);


        //Edit observation -------------------------------
        Observation nr8 = new Observation(7, "Amphibian", snake, LocalDate.now(), 6, "http", locationJupiter, "Never ever look at this!");
        mapOfLifeRepository.editObservation(7, nr8);
        */

        //Connect controller
        MapOfLifeRepository mapOfLifeRepository = new MapOfLifeRepository("mapoflife.json");
        MapOfLifeController mapOfLifeController = new MapOfLifeController(mapOfLifeRepository);




        //UI

        Javalin app = Javalin.create().start(7001);
        app.config.enableWebjars();
        app.before("/", ctx -> ctx.redirect("/observations"));
        app.get("/observations", new VueComponent("observations-overview"));

        app.get("/api/observations", mapOfLifeController::getObservations);


    }
}
