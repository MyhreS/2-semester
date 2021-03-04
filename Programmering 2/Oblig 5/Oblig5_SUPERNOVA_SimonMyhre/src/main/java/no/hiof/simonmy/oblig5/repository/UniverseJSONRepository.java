package no.hiof.simonmy.oblig5.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.hiof.simonmy.oblig5.model.Planet;
import no.hiof.simonmy.oblig5.model.PlanetSystem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniverseJSONRepository implements IUniversityRepository {
    private List<PlanetSystem> planetSystems;



    public UniverseJSONRepository(String filename) {
        List<PlanetSystem> planetSys = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            PlanetSystem[] planetSystemsArray = objectMapper.readValue(new File(filename), PlanetSystem[].class);
            planetSys = Arrays.asList(planetSystemsArray);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        this.planetSystems = planetSys;
    }


    @Override
    public List<PlanetSystem> readFromJson(String fileName) {
        List<PlanetSystem> planetSys = new ArrayList<>();

        try {
        ObjectMapper objectMapper= new ObjectMapper();

        PlanetSystem[] planetSysArray = objectMapper.readValue(new File(fileName), PlanetSystem[].class);

        planetSys = Arrays.asList(planetSysArray);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return planetSys;
    }

    /*
    Kode: Det du har fungerer nesten, som det skal. Det oppdaterer jo UI men skrives ikke til jsonfilen.
    Det som er problemet her er at i writeToJson metoden din så kaller du readFromJson for det du skal skrive inn.
    Her er jo readToJson alltid den gamle filen siden oppdateringene ikke kommer inn så du får en loop hvor du bare skriver over dataen med den samme dataen.
    Erstatter du derimot " objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, readFromJson(filename)); "
    Til: " objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, planetSystems); " Så fungerer alt som det skal
     */
    @Override
    public void writeToNewJson(String filename)  {

        try {
            File file = new File(filename);
            ObjectMapper objectMapper = new ObjectMapper();

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, readFromJson(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public PlanetSystem getPlanetSystem(String planetSystemName) {
        for (PlanetSystem planetSystem : planetSystems) {
            if (planetSystem.getName().equals(planetSystemName)) {
                return planetSystem;
            }
        }

        return null;
    }

    @Override
    public ArrayList<PlanetSystem> getPlanetSystems() {
        return new ArrayList<>(planetSystems);
    }

    @Override
    public Planet getPlanet(String planetSystemName, String planet) {
        return getPlanetSystem(planetSystemName).getPlanet(planet);
    }

    @Override
    public ArrayList<Planet> getPlanets(String planetSystemName) {
        return getPlanetSystem(planetSystemName).getPlanets();
    }

    @Override
    public void deleteAPlanet(String planetSystemName, String planetName) {
        PlanetSystem delFromThisPlanetSys = getPlanetSystem(planetSystemName);
        Planet delThisPlanet = getPlanet(planetSystemName, planetName);
        delFromThisPlanetSys.removePlanet(delThisPlanet);
    }

    @Override
    public void createAPlanet(String planetSystemName, Planet planetName) {
        PlanetSystem pSys = getPlanetSystem(planetSystemName);
        pSys.addPlanet(planetName);
    }

    public void editPlanet(Planet fromPlanet, Planet toPlanet) {
        fromPlanet.editAPlanetObject(toPlanet);
    }

    @Override
    public void writeToCSVFile(String fileName) {
    }
}
