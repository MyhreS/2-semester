package no.hiof.larseknu.flyoversikt;

public class Main {

    public static void main(String[] args) {
        Fly boeing737 = new Fly("Boeing-737", 150);

        boeing737.leggTilEnPassasjer();

        boeing737.leggTilEnPassasjer();
        boeing737.leggTilEnPassasjer();
        boeing737.leggTilEnPassasjer();
        boeing737.leggTilEnPassasjer();

        Transportfly and233 = new Transportfly("An-223", 5, 8000);

        and233.leggTilEnPassasjer();
        and233.leggTilEnPassasjer();
        and233.leggTilEnPassasjer();
        and233.leggTilEnPassasjer();

        System.out.println("Totalt antall passasjerer i flåten: " + Fly.getTotalAntallPassasjerer());
    }
}
