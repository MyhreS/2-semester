package hiof.controller;

import hiof.repository.UniverseRepository;
import hiof.model.Planet;
import io.javalin.http.Context;

import java.util.ArrayList;
import java.util.Comparator;


public class PlanetController {
    private UniverseRepository universeRepository;

    public PlanetController(UniverseRepository universeRepository) {
        this.universeRepository = universeRepository;
    }

    public void getControllerAllePlaneter(Context ctx) {


        String id = ctx.pathParam("planet-system-id");
        String sort = ctx.queryParam("sort_by");
        ArrayList<Planet> placeholder = new ArrayList<>(universeRepository.getAllePlaneter(id));

        if(sort.equals("name")) {
            placeholder.sort(new Comparator<Planet>() {
                @Override
                public int compare(Planet o1, Planet o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
        }



        else if(sort.equals("radius")) {

            placeholder.sort(new Comparator<Planet>() {
                @Override
                public int compare(Planet o1, Planet o2) {

                    if(o1.getRadius() == o2.getRadius()) {
                        return 0;
                    }

                    else if(o1.getRadius() > o2.getRadius()) {
                        return 1;
                    }

                    else {
                        return -1;
                    }
                }
            });
        }



        else if(sort.equals("nun"))  {
            placeholder = new ArrayList<>(universeRepository.getAllePlaneter(id));
        }

        ctx.json(placeholder);
    }


    public void getControllerSpesifikkPlanet(Context ctx) {
        String id = ctx.pathParam("planet-system-id");
        String navn = ctx.pathParam(":planet-id");

        ctx.json(universeRepository.getSpesifikkPlanet(id, navn));
    }
}
