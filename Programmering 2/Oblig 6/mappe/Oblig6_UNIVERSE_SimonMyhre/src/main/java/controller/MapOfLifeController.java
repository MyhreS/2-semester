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
}
