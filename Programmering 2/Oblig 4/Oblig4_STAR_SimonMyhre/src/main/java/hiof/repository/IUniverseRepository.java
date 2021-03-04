package hiof.repository;

import hiof.model.*;

import java.util.ArrayList;

public interface IUniverseRepository {
    ArrayList<PlanetSystem> getAllePlanetSystemer();
    PlanetSystem getSpesifiktPlanetSystem(String id);
    ArrayList<Planet> getAllePlaneter(String id);
    Planet getSpesifikkPlanet(String id, String navn);
}


