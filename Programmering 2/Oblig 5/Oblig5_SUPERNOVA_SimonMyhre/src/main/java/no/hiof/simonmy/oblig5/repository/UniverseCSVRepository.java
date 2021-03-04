package no.hiof.simonmy.oblig5.repository;

import no.hiof.simonmy.oblig5.model.Planet;
import no.hiof.simonmy.oblig5.model.PlanetSystem;
import no.hiof.simonmy.oblig5.model.Star;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniverseCSVRepository implements IUniversityRepository {
    private Map<String, PlanetSystem> planetSysMap = new HashMap<>();


    //planetSysMap.put(del[0], new Planetsystem(psys_name, psys_pictureUrl))

    public UniverseCSVRepository(String filename) {
        //Hashmappet og arraylisten PlanetSystem som blir lagt til
        Map<String, PlanetSystem> planetSysMap = new HashMap<String, PlanetSystem>();
        ArrayList<PlanetSystem> planetSys = new ArrayList<>();

        //Noen variabler som brukes
        Star starObject = null;
        PlanetSystem planetSysObject = null;
        String lastDeler = "";
        ArrayList<String> doesItContainThis = new ArrayList<>();


        try (BufferedReader bufretLeser = new BufferedReader(new FileReader(filename))) {
            String linje;

            //Løkke som kjører gjennom alle linjene. Den stopper når linjen er "" altså = linje
            while ((linje = bufretLeser.readLine()) != null) {
                String[] deler = linje.split(",");

                //Legger til arrayen i Hashmappet
                if(!deler[0].equals(lastDeler) && !lastDeler.equals("")) {
                    planetSysMap.put(lastDeler, planetSysObject);
                }

                //Trenger "lastDeler" for å finne ut hva det forrige navnet på solsystemet var
                lastDeler = deler[0];

                //Gjør om verdiene slik at de kan bli lagt inn i PlanetSystem, Star og Planet
                double toMass = Double.parseDouble(deler[3]);
                double toRadius = Double.parseDouble(deler[4]);
                double toEffectiveTemp = Double.parseDouble(deler[5]);
                double toMassP = Double.parseDouble(deler[8]);
                double toRadiusP = Double.parseDouble(deler[9]);
                double toSemiMajorAxisP = Double.parseDouble(deler[10]);
                double toEccentricityP = Double.parseDouble(deler[11]);
                double toOrbitPP = Double.parseDouble(deler[12]);

                //Hvis ikke det planetsystemet fins så lager den et nytt
                if(!doesItContainThis.contains(deler[0])) {
                    starObject = new Star(deler[2], toMass, toRadius, toEffectiveTemp, deler[6]);
                    planetSysObject = new PlanetSystem(deler[0], starObject, deler[1]);
                }
                //Legger til planet i planetsystemet
                planetSysObject.addPlanet(new Planet(deler[7], toMassP, toRadiusP, toSemiMajorAxisP, toEccentricityP, toOrbitPP, starObject, deler[13]));

                //Legger til planetSystemet i et array. Men på den betingelsen at det ikke allerede er lagt til akkurat det planetsystemet
                if(!doesItContainThis.contains(deler[0])) {
                    planetSys.add(planetSysObject);
                    doesItContainThis.add(deler[0]);
                }
            }

            //Legger til det siste planetsystemet i Hashmappet når det er ferdig
            planetSysMap.put(lastDeler, planetSysObject);

        } catch (FileNotFoundException fnfe) {
            // Skriver ut feilmelding om filen ikke finnes
            System.out.println(fnfe.getMessage());
        } catch (IOException ioexc) {
            // skriver ut feilmelding om det oppstår feil ved skriving til fil
            System.out.println(ioexc.getLocalizedMessage());
        }

        //Returnerer hele hashmappet
        this.planetSysMap = planetSysMap;

        deleteAPlanet("Solar System", "Earth");
    }

    @Override
    public PlanetSystem getPlanetSystem(String planetSystemName) {
            return planetSysMap.get(planetSystemName);
    }

    @Override
    public ArrayList<PlanetSystem> getPlanetSystems() {
        return new ArrayList<>(planetSysMap.values());
    }

    @Override
    public Planet getPlanet(String planetSystemName, String planet) {
        return getPlanetSystem(planetSystemName).getPlanet(planet);
    }

    @Override
    public ArrayList<Planet> getPlanets(String planetSystemName) {
        return getPlanetSystem(planetSystemName).getPlanets();
    }

    public void writeToCSVFile(String fileName) {
        ArrayList<PlanetSystem> list = new ArrayList<PlanetSystem>(planetSysMap.values());

        try (BufferedWriter bufretSkriver = new BufferedWriter(new FileWriter(fileName))) {

            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).getPlanets().size() > 1) {
                    for(int a = 0; a < list.get(i).getPlanets().size(); a++) {
                        bufretSkriver.write(list.get(i).getName() + "," + list.get(i).getPictureUrl() + "," + list.get(i).getCenterStar().getName() + "," + list.get(i).getCenterStar().getMass() + "," + list.get(i).getCenterStar().getRadius() + "," + list.get(i).getCenterStar().getEffectiveTemperature() + "," + list.get(i).getCenterStar().getPictureUrl() + "," + list.get(i).getPlanets().get(a).getName() + "," + list.get(i).getPlanets().get(a).getMass() + "," + list.get(i).getPlanets().get(a).getRadius() + "," + list.get(i).getPlanets().get(a).getSemiMajorAxis() + "," + list.get(i).getPlanets().get(a).getEccentricity() + "," + list.get(i).getPlanets().get(a).getOrbitalPeriod() + "," + list.get(i).getPlanets().get(a).getPictureUrl());
                        bufretSkriver.newLine();
                        //System.out.println("Ja");
                    }
                }
                else {
                    bufretSkriver.write(list.get(i).getName() + "," + list.get(i).getPictureUrl() + "," + list.get(i).getCenterStar().getName() + "," + list.get(i).getCenterStar().getMass() + "," + list.get(i).getCenterStar().getRadius() + "," + list.get(i).getCenterStar().getEffectiveTemperature() + "," + list.get(i).getCenterStar().getPictureUrl() + "," + list.get(i).getPlanets().get(0).getName() + "," + list.get(i).getPlanets().get(0).getMass() + "," + list.get(i).getPlanets().get(0).getRadius() + "," + list.get(i).getPlanets().get(0).getSemiMajorAxis() + "," + list.get(i).getPlanets().get(0).getEccentricity() + "," + list.get(i).getPlanets().get(0).getOrbitalPeriod() + "," + list.get(i).getPlanets().get(0).getPictureUrl());
                    bufretSkriver.newLine();
                    //System.out.println("Nei");
                }
            }

        } catch (FileNotFoundException fnfe) {
            // Skriver ut feilmelding om filen ikke finnes
            System.out.println(fnfe.getMessage());
        } catch (IOException ioexc) {
            // skriver ut feilmelding om det oppstår feil ved skriving til fil
            System.out.println(ioexc.getLocalizedMessage());
        }
    }

    @Override
    public void deleteAPlanet(String planetSystemName, String planetName) {

    }

    @Override
    public void createAPlanet(String planetSystemName, Planet planetName) {

    }

    @Override
    public void editPlanet(Planet fromPlanet, Planet toPlanet) {

    }

    @Override
    public List<PlanetSystem> readFromJson(String fileName) {
        return null;
    }

    @Override
    public void writeToNewJson(String filename) {
    }

}
