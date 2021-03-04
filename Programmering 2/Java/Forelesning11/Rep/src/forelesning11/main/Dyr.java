package forelesning11.main;

import java.time.LocalDate;

public class Dyr implements Comparable<Dyr>{
    private String navn;
    private final int id;
    private LocalDate fodselsdato;

    private final int startId = 1000;
    private static int dyreTeller = 0;

    public Dyr(String navn) {
        this(navn, LocalDate.EPOCH);
    }

    public Dyr(String navn, LocalDate fodselsdato) {
        this.navn = navn;
        this.fodselsdato = fodselsdato;
        id = startId + ++dyreTeller;
    }

    public String getNavn() {

        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getId() {
        return id;
    }

    public LocalDate getFodselsdato() {
        return fodselsdato;
    }

    public void setFodselsdato(LocalDate fodselsdato) {
        this.fodselsdato = fodselsdato;
    }

    @Override
    public int compareTo(Dyr sammenligningsDyr) {
        return navn.compareTo(sammenligningsDyr.getNavn());
    }

    @Override
    public String toString() {
        return id + " - " + navn + " - " + getFodselsdato();
    }
}
