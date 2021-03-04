import java.util.Scanner;

public class Oppgave3_1 {

    public static void main(String[] args) {

        Planet jorden = new Planet();
        
        System.out.print("Angi navn pa planet: ");
        Scanner scanner = new Scanner(System.in);
        jorden.setName(scanner.nextLine());

        System.out.print("Angi radiusen pa planet: ");
        jorden.setRadius(scanner.nextDouble());

        System.out.print("Angi gravitasjonen pa planet: ");
        jorden.setGravitation(scanner.nextDouble());

        System.out.println("Planeten " + jorden.getName() + " har en radius på " + jorden.getRadius() + " og en gravitasjon på " + jorden.getGravitation() + " m/s2");
    }
}