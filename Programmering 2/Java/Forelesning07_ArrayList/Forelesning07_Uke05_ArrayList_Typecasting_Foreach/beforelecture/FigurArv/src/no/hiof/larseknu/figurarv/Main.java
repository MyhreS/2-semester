package no.hiof.larseknu.figurarv;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Sirkel sirkel1 = new Sirkel(10);
        Sirkel sirkel2 = new Sirkel(3);

        Rektangel rektangel1 = new Rektangel(5, 6);
        Rektangel rektangel2 = new Rektangel(10, 15);

        Kvadrat kvadrat1 = new Kvadrat(8);
        Kvadrat kvadrat2 = new Kvadrat(3);

        ArrayList<Figur> figurListe = new ArrayList<>();

        figurListe.add(rektangel1);
        figurListe.add(rektangel2);
        figurListe.add(kvadrat1);
        figurListe.add(kvadrat2);
        figurListe.add(sirkel1);
        figurListe.add(sirkel2);

        for(Figur figur : figurListe) {
            // int i = 0; i < figurListe.size(); i++
            // Figur figur = figurListe.get(i);

           System.out.println(figur + " med areal: " + figur.areal() + " og omkrets " + figur.omkrets());
            // System.out.println(String.format("%s med areal: %.2f og omkrets: %.0f", figur, figur.areal(), figur.omkrets()));

            if (figur instanceof Sirkel) {
                Sirkel enSirkel = (Sirkel)figur;
                System.out.println(enSirkel.beregnDiameter());
            }

            else {
                System.out.println("Ikke en sirkel");
            }

        }
    }
}
