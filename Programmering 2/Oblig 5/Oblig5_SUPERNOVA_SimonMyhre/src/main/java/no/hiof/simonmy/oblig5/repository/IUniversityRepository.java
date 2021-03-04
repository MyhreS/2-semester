package no.hiof.simonmy.oblig5.repository;

import no.hiof.simonmy.oblig5.model.Planet;
import no.hiof.simonmy.oblig5.model.PlanetSystem;

import java.util.ArrayList;
import java.util.List;

public interface IUniversityRepository {
    PlanetSystem getPlanetSystem(String planetSystemName);
    ArrayList<PlanetSystem> getPlanetSystems();
    Planet getPlanet(String planetSystemName, String planet);
    ArrayList<Planet> getPlanets(String planetSystemName);
    List<PlanetSystem> readFromJson(String fileName);
    void writeToNewJson(String filename);
    void writeToCSVFile(String fileName);
    void deleteAPlanet(String planetSystemName, String planetName);
    void createAPlanet(String planetSystemName, Planet planetName);
    void editPlanet(Planet fromPlanet, Planet toPlanet);
}
