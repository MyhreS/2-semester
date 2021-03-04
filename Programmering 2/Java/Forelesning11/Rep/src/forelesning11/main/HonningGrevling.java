package forelesning11.main;

import java.time.LocalDate;

public class HonningGrevling extends Dyr {
    private int antallSlangerDrept;


    public HonningGrevling(String navn, LocalDate fodselsdato) {
        super(navn, fodselsdato);
        antallSlangerDrept = 0;
    }

    public int getAntallSlangerDrept() {
        return antallSlangerDrept;
    }

    public void dreptEnSlangeTil() {
        antallSlangerDrept++;
    }
}
