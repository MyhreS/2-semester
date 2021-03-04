package forelesning11.main;

public class Panda extends Dyr {
    private String belteFarge;

    public Panda(String navn, String belteFarge) {
        super(navn);
        this.belteFarge = belteFarge;
    }

    public String getBelteFarge() {
        return belteFarge;
    }

    public void setBelteFarge(String belteFarge) {
        this.belteFarge = belteFarge;
    }
}
