package hiof;

import hiof.controller.PlanetController;
import hiof.controller.UniverseController;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.plugin.rendering.vue.VueComponent;
import org.jetbrains.annotations.NotNull;
import hiof.repository.UniverseRepository;

public class Application {
    public static void main(String[] args) {
        Javalin program = Javalin.create().start();

        program.config.enableWebjars();

        program.get("/", new Handler() {
            @Override
            public void handle(@NotNull Context ctx) throws Exception {
                ctx.result("Hello World!");
            }
        });





        UniverseRepository universeRepository = new UniverseRepository();
        UniverseController planetSystemController = new UniverseController(universeRepository);


        //PlanetSystem
        program.get("/planet-systems", new VueComponent("planet-system-overview"));
        program.get("/api/planet-systems", new Handler() {
            @Override
            public void handle(@NotNull Context ctx) throws Exception {
                planetSystemController.getControllerAllePlanetSystem(ctx);
            }
        });

        program.get("/planet-systems/:planet-system-id", new VueComponent("planet-system-detail"));
        program.get("/api/planet-systems/:planet-system-id", new Handler() {
            @Override
            public void handle(@NotNull Context ctx) throws Exception {
                planetSystemController.getControllerSpesifiktPlanetSystem(ctx);
            }
        });



        //Planets
        PlanetController planetController = new PlanetController(universeRepository);

        program.get("/planet-systems/:planet-system-id/planets/:planet-id", new VueComponent("planet-detail"));
        program.get("/api/planet-systems/:planet-system-id/planets", new Handler() {
            @Override
            public void handle(@NotNull Context ctx) throws Exception {
                planetController.getControllerAllePlaneter(ctx);
            }
        });

        program.get("/api/planet-systems/:planet-system-id/planets/:planet-id", new Handler() {
            @Override
            public void handle(@NotNull Context ctx) throws Exception {
                planetController.getControllerSpesifikkPlanet(ctx);
            }
        });
    }
}
