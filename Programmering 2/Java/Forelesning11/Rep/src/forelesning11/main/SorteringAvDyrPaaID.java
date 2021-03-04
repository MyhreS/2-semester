package forelesning11.main;

import java.util.Comparator;

public class SorteringAvDyrPaaID implements Comparator<Dyr> {

    @Override
    public int compare(Dyr dyr1, Dyr dyr2) {
        return dyr1.getId() - dyr2.getId();
    }
}
