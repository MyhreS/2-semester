package forelesning11.main;

import java.util.ArrayList;

public class DyrePark {
    private String navn;
    private ArrayList<Dyr> dyreList = new ArrayList<>();

    public DyrePark(String navn) {
        this.navn = navn;
    }

    public ArrayList<Dyr> getDyreList() {
        return new ArrayList<>(dyreList);
    }

    public void leggTilEttDyr(Dyr ettDyr) {
        dyreList.add(ettDyr);
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}
