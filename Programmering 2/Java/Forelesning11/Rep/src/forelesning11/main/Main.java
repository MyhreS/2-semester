package forelesning11.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        DyrePark kristiansand = new DyrePark("Kristiansand Dyrepark");
        Panda tina = new Panda("Tina", "Gult");
        Sjimpanse arne = new Sjimpanse("Arne", LocalDate.of(2017, 8, 8), 75);

        kristiansand.leggTilEttDyr(tina);
        kristiansand.leggTilEttDyr(arne);

        ArrayList<Dyr> dyreListeKopi = kristiansand.getDyreList();
        skrivUtDyrIListe(dyreListeKopi);

        /*
         DyrePark kristiansand = new DyrePark("Kristiansand Dyrepark");
         Panda tina = new Panda("Tina", "Gult");
         Sjimpanse arne = new Sjimpanse("Arne", LocalDate.of(2017, 8, 8), 75);
         HonningGrevling nils = new HonningGrevling("Nils", LocalDate.of(2019, 2, 5));


         kristiansand.leggTilEttDyr(tina);
         kristiansand.leggTilEttDyr(arne);
         kristiansand.leggTilEttDyr(nils);


        System.out.println(arne.getId() + " Sjimpansen " + arne.getNavn() + " har en IQ på " + arne.getIq());
        System.out.println(nils.getId() + " Honninggrevlingen " + nils.getNavn() + " har drept " + nils.getAntallSlangerDrept());
        System.out.println(tina.getId() + " Panda " + tina.getNavn() + " har " + tina.getBelteFarge() + " belte " + tina.getFodselsdato());

        System.out.println("------Rekkefølge i array");
        ArrayList<Dyr> dyreListeKopi = kristiansand.getDyreList();
        skrivUtDyrIListe(dyreListeKopi);
        System.out.println("------Navn");
        Collections.sort(dyreListeKopi);
        skrivUtDyrIListe(dyreListeKopi);

        System.out.println("------ID");
        Collections.sort(dyreListeKopi, new SorteringAvDyrPaaID());
        skrivUtDyrIListe(dyreListeKopi);

        System.out.println("------Dato sortering i Main");
        Collections.sort(dyreListeKopi, new Comparator<Dyr>() {
            @Override
            public int compare(Dyr dyr1, Dyr dyr2) {
                return dyr1.getFodselsdato().compareTo(dyr2.getFodselsdato());
            }
        });
        skrivUtDyrIListe(dyreListeKopi);


         */

    }

    private static void skrivUtDyrIListe(ArrayList<Dyr> dyreList) {
        for (Dyr etDyr : dyreList) {
            System.out.println(etDyr);
        }
    }
}
