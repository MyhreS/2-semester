package model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.jetbrains.annotations.NotNull;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Birds.class, name = "birds"),
        @JsonSubTypes.Type(value = Amphibians.class, name = "amphibians"),
        @JsonSubTypes.Type(value = Invertebrates.class, name = "invertebrates")
})




public class Animals implements Comparable<Animals>{
    private String name;
    private String scientificName;


    //Constructor
    public Animals() {
    }

    public Animals(String name, String scientificName) {
        this.name = name;
        this.scientificName = scientificName;
    }


    //Get and set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }


    //toString
    @Override
    public String toString() {
        return String.format("[name=%s, scientificName=%s]", name, scientificName);
    }


    //compareTo
    @Override
    public int compareTo(@NotNull Animals a) {
        return this.name.compareTo(a.getName());
    }
}
