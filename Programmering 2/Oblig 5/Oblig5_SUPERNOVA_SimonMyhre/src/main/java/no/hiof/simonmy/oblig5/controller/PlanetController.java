package no.hiof.simonmy.oblig5.controller;

import io.javalin.http.Context;
import no.hiof.simonmy.oblig5.model.Planet;
import no.hiof.simonmy.oblig5.model.Star;
import no.hiof.simonmy.oblig5.repository.IUniversityRepository;

import java.util.ArrayList;
import java.util.Collections;

public class PlanetController {
    private IUniversityRepository universityRepository;

    public PlanetController(IUniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public void getPlanets(Context context) {
        String planetSystemName = context.pathParam("planet-system-id");
        String sortBy = context.queryParam("sort_by");

        ArrayList<Planet> planets = universityRepository.getPlanets(planetSystemName);

        if (sortBy != null) {
            switch (sortBy) {
                case "name":
                    Collections.sort(planets);
                    break;
                case "mass":
                    planets.sort((o1, o2) -> (int) (o1.getMass() - o2.getMass()));
                    break;
                case "radius":
                    planets.sort((o1, o2) -> {
                        if (o1.getRadius() < o2.getRadius())
                            return -1;
                        else if(o1.getRadius() > o2.getRadius())
                            return 1;
                        return 0;
                    });
                    break;
            }
        }


        context.json(planets);
    }

    public void getPlanet(Context context) {
        String planetSystemName = context.pathParam("planet-system-id");
        String planetName = context.pathParam("planet-id");

        context.json(universityRepository.getPlanet(planetSystemName, planetName));
    }


    public void deletePlanet(Context context) {
        String planetSystemName = context.pathParam("planet-system-id");
        String planetName = context.pathParam("planet-id");

        universityRepository.deleteAPlanet(planetSystemName, planetName);

        context.redirect("/planet-systems/" + planetSystemName);
    }

    public Planet planetForm(Context context) {
        String planetSystemName = context.pathParam("planet-system-id");

        String pName = context.formParam("name");
        String pictureUrl = context.formParam("pictureUrl");
        double pMass = Double.parseDouble(context.formParam("mass"));
        double pRadius = Double.parseDouble(context.formParam("radius"));
        double pSemiMA = Double.parseDouble(context.formParam("semiMajorAxis"));
        double pEccentricity = Double.parseDouble(context.formParam("eccentricity"));
        double pOrbitP = Double.parseDouble(context.formParam("mass"));

        Star starObject = universityRepository.getPlanetSystem(planetSystemName).getCenterStar();
        Planet planetObject = new Planet(pName, pMass, pRadius, pSemiMA, pEccentricity, pOrbitP, starObject, pictureUrl);

        return planetObject;

    }

    public void createPlanet(Context context) {
        String planetSystemName = context.pathParam("planet-system-id");

        Planet planet =  planetForm(context);
        universityRepository.createAPlanet(planetSystemName, planet);

        context.redirect("/planet-systems/" + planetSystemName);
    }

    public void editAPlanet(Context context) {
        String planetSystemName = context.pathParam("planet-system-id");
        String planetName = context.pathParam("planet-id");

        Planet fromPlanet = universityRepository.getPlanet(planetSystemName, planetName);
        Planet toPlanet =  planetForm(context);
        universityRepository.editPlanet(fromPlanet, toPlanet);

        context.redirect("/planet-systems/" + planetSystemName);
    }


}
