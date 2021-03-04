package forelesning11.main;

import java.time.LocalDate;

public class Sjimpanse extends Dyr {
    private int iq;

    public Sjimpanse(String navn, LocalDate fodselsdato, int iq) {
        super(navn, fodselsdato);
        this.iq = iq;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }
}
