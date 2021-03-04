package repository;

import model.*;

import java.util.ArrayList;
import java.util.List;

public interface IMapOfLifeRepository {
    Observation getObservation(double id);
    List<Observation> getObservations();
    void writeToFile(String filename);
    List<Observation> readFromFile(String filename);
    void createObservation(Observation newObservation);
    void deleteObservation(double id);
    void editObservation(double id, Observation toObservation);

}
