package no.hiof.larseknu.figurarv;

/**
 * Klasse som representerer en generisk figur
 */
public abstract class Figur {
    private String farge;

    public Figur(String farge) {
        this.farge = farge;
    }

    public String getFarge() {
        return farge;
    }

    public void setFarge(String farge) {
        this.farge = farge;
    }

    public abstract double areal();

    public abstract double omkrets();

    public static boolean erStorre(Figur figur1, Figur figur2)
    {
        return figur1.areal() > figur2.areal();
    }

    public boolean erStorreMetodeSomIkkeErStatisk(Figur figur1, Figur figur2)
    {
        return figur1.areal() > figur2.areal();
    }

    public boolean erStorreMetodeSomIkkeErStatisk(Figur sammenligningsFigur)
    {
        return this.areal() > sammenligningsFigur.areal();
    }

}
