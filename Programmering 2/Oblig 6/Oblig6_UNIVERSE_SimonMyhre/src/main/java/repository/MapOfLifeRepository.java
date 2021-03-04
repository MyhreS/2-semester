package repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapOfLifeRepository implements IMapOfLifeRepository{
    private List<Observation> observationList;

    public MapOfLifeRepository(String filename) {
        List<Observation> ob = new ArrayList<>();

        try {
            ObjectMapper objectMapper= new ObjectMapper();
            objectMapper.registerModule((new JavaTimeModule()));
            Observation[] obList = objectMapper.readValue(new File(filename), Observation[].class);

            ob = Arrays.asList(obList);

        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        //ArrayList<Observation> transformToArrayList = new ArrayList<>(ob);
        //return transformToArrayList;

        this.observationList = ob;
    }


    @Override
    public Observation getObservation(double id) {
        for(Observation o : observationList) {
            if(o.getId() == id) {
                return o;
            }
        }

        return null;
    }


    @Override
    public List<Observation> getObservations() {
        List<Observation> list = new ArrayList<>(observationList);
        return list;


    }

    @Override
    public void writeToFile(String filename) {
        try {
            File file = new File(filename);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule((new JavaTimeModule()));

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, observationList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Observation> readFromFile(String filename) {
        List<Observation> ob = new ArrayList<>();

        try {
            ObjectMapper objectMapper= new ObjectMapper();
            objectMapper.registerModule((new JavaTimeModule()));

            Observation[] obList = objectMapper.readValue(new File(filename), Observation[].class);

            ob = Arrays.asList(obList);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        //ArrayList<Observation> transformToArrayList = new ArrayList<>(ob);
        //return transformToArrayList;
        return ob;
    }

    @Override
    public void createObservation(Observation newObservation) {
        //This only creates an observation in Arraylist
        observationList.add(newObservation);
    }


    @Override
    public void deleteObservation(double id) {
        Observation observation = getObservation(id);
        List<Observation> holder = new ArrayList<>(observationList);
        holder.remove(observation);
        observationList = holder;
    }

    @Override
    public void editObservation(double id, Observation toObservation) {

        for(int i = 0; i < observationList.size(); i++) {
            if(observationList.get(i).getId() == id) {
                observationList.set(i, toObservation);
            }
        }
    }
}
