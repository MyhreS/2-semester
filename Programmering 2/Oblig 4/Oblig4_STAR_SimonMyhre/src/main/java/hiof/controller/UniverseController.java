package hiof.controller;

import hiof.model.Planet;
import hiof.model.PlanetSystem;
import hiof.repository.UniverseRepository;
import io.javalin.http.Context;
// import hiof.model.*;
import java.util.ArrayList;

public class UniverseController {
    private UniverseRepository universeRepository;

    public UniverseController(UniverseRepository universeRepository) {
        this.universeRepository = universeRepository;
    }

    public void getControllerAllePlanetSystem(Context ctx) {

        /*
        ArrayList<PlanetSystem> allePlanetSys = universeRepository.getAllePlanetSystemer();
        ctx.json(allePlanetSys);


         */
        ctx.json(universeRepository.getAllePlanetSystemer());
    }

    public void getControllerSpesifiktPlanetSystem(Context ctx) {
        String id = ctx.pathParam(":planet-system-id");
        ctx.json(universeRepository.getSpesifiktPlanetSystem(id));
    }

    /*
    public UniverseController(IUniverseRepository universeRepository) {
        this.universeRepository = universeRepository;
    }

    public void getAllPlanets(Context context) {
        String solSystemId = context.pathParam("planet-systems-id");

        ArrayList<Planet> allPlanets = universeRepository.getAllePlaneterIPlanetSystem(solSystemId);

        context.json(allPlanets);
    }
*/

}
