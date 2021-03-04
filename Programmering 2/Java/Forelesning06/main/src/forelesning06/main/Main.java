package forelesning06.main;

public class Main {

    public static void main(String[] args) {
        Rektangel etRektangel = new Rektangel(5,7);
        System.out.println("Rektangelet har O: " + etRektangel.omkrets() + " og A: " + etRektangel.areal());

        Sirkel enSirkel = new Sirkel(10);
        System.out.println("Sirkelen har areal: " + enSirkel.areal());

        Kvadrat etKvadrat = new Kvadrat(5);
        System.out.println("Kvadrat har omkrets: " + etKvadrat.omkrets() + " og areal: " + etKvadrat.areal());

        if (erStorre(etRektangel, enSirkel)) {
            System.out.println("Rektangelet er større enn sirkelen");
        }
        else {
            System.out.println("Sirkelen er større enn rektangelet");
        }
        if (erStorre(etRektangel, etKvadrat)) {
            System.out.println("Rektangelet er større enn kvadratet");
        }
        else {
            System.out.println("Kvadratet er større enn rektangelet");
        }
    }

    public static boolean erStorre(Figur figur1, Figur figur2) {
        return figur1.areal() > figur2.areal();
    }
}
