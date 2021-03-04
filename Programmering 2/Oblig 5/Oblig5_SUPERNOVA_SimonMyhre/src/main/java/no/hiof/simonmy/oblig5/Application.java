package no.hiof.simonmy.oblig5;

import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.VueComponent;
import no.hiof.simonmy.oblig5.controller.PlanetController;
import no.hiof.simonmy.oblig5.controller.PlanetSystemController;
import no.hiof.simonmy.oblig5.repository.UniverseJSONRepository;

public class Application {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7001);

        app.config.enableWebjars();

        app.before("/", ctx -> ctx.redirect("/planet-systems"));

        //UniverseCSVRepository universeRepository = new UniverseCSVRepository("planets_100.csv");
        UniverseJSONRepository universeRepository = new UniverseJSONRepository("planets_100.json");
        PlanetSystemController planetSystemController = new PlanetSystemController(universeRepository);
        PlanetController planetController = new PlanetController(universeRepository);

        app.get("/planet-systems", new VueComponent("planet-system-overview"));
        app.get("/planet-systems/:planet-system-id", new VueComponent("planet-system-detail"));
        app.get("/planet-systems/:planet-system-id/planets/:planet-id", new VueComponent("planet-detail"));
        app.get("/planet-systems/:planet-system-id/createplanet", new VueComponent("planet-create"));
        app.get("/planet-systems/:planet-system-id/planets/:planet-id/update", new VueComponent("planet-update"));

        //Lage run() med Thread
        Thread writeJSONThread = new Thread(() -> universeRepository.writeToNewJson("planets_100.json"));

        //Get planetSystems
        app.get("api/planet-systems", planetSystemController::getAllPlanetSystems);
        app.get("api/planet-systems/:planet-system-id", planetSystemController::getPlanetSystem);

        //Get planets
        app.get("/api/planet-systems/:planet-system-id/planets", planetController::getPlanets);
        app.get("/api/planet-systems/:planet-system-id/planets/:planet-id", planetController::getPlanet);

        //Delete planet
        //app.get("/api/planet-systems/:planet-system-id/planets/:planet-id/delete", planetController::deletePlanet);
        app.get("/api/planet-systems/:planet-system-id/planets/:planet-id/delete", ctx -> {
            planetController.deletePlanet(ctx);
            new Thread(writeJSONThread).start();
                });


        //Create planet
        //app.post("/api/planet-systems/:planet-system-id/createplanet", planetController::createPlanet);
        app.post("/api/planet-systems/:planet-system-id/createplanet", ctx -> {
            planetController.createPlanet(ctx);
            new Thread(writeJSONThread).start();
        });

        //Edit planet
        app.post("/api/planet-systems/:planet-system-id/planets/:planet-id/update", ctx -> {
            planetController.editAPlanet(ctx);
            new Thread(writeJSONThread).start();
        });
    }
}
