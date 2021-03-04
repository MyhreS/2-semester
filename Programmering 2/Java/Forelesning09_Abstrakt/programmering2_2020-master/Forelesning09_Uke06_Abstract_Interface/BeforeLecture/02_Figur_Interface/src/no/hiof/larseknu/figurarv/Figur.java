package no.hiof.larseknu.figurarv;

/**
 * Abstract Klasse som representerer en generisk figur
 * Kan ikke opprettes egne objekter av Figur-klassen (siden den er abstract)
 */
public abstract class Figur  implements Tegnbar, Comparable<Figur> {
    private String farge;

    public Figur(String farge) {
        this.farge = farge;
    }

    public abstract double areal();

    public abstract double omkrets();

    @Override
    public int compareTo(Figur sammenligningsFigur) {

        if(this.areal() > sammenligningsFigur.areal())
            return 1;
        else if (this.areal() < sammenligningsFigur.areal())
            return -1;

        return 0;
    }

    public String getFarge() {
        return farge;
    }

    public void setFarge(String farge) {
        this.farge = farge;
    }
}
