package controller;

import repository.IMapOfLifeRepository;
import repository.MapOfLifeRepository;

import io.javalin.http.Context;

public class MapOfLifeController {
    private IMapOfLifeRepository mapOfLifeRepository;

    public MapOfLifeController(IMapOfLifeRepository mapOfLifeRepository) {
        this.mapOfLifeRepository = mapOfLifeRepository;
    }

    public void getObservations(Context context) {
        context.json(mapOfLifeRepository.getObservations());
    }

    public void getObservation(Context context) {
        String observationId = context.pathParam("observations-id");
        double id = Double.parseDouble(observationId);
        context.json(mapOfLifeRepository.getObservation(id));
    }

    public void deleteAObservation(Context context) {
        String observationId = context.pathParam("observations-id");
        double id = Double.parseDouble(observationId);
        mapOfLifeRepository.deleteObservation(id);

        context.redirect("/observations");
    }
}
