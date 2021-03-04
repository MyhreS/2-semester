package no.hiof.simonmy.oblig5.controller;

import io.javalin.http.Context;
import no.hiof.simonmy.oblig5.repository.IUniversityRepository;



public class PlanetSystemController {
    private IUniversityRepository universityRepository;

    public PlanetSystemController(IUniversityRepository universeRepository) {
        this.universityRepository = universeRepository;
    }

    public void getAllPlanetSystems(Context context) {
        context.json(universityRepository.getPlanetSystems());
    }

    public void getPlanetSystem(Context context) {
        String planetSystemName = context.pathParam("planet-system-id");
        context.json(universityRepository.getPlanetSystem(planetSystemName));
    }

}
