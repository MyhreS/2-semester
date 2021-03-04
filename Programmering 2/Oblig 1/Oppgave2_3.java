

public class Oppgave2_3 {

    public static void main(String[] args) {
        //legge til planet
        Planet jorden = new Planet("Jorden", 85, 100);
        
        //Skrive ut planet
        //System.out.println("Planet: " + jorden.getName() + ", Radius: " + jorden.getRadius() + ", Gravitation: " + jorden.getGravitation() + "%");
        System.out.println("Planeten " + jorden.getName() + " har en radius på " + jorden.getRadius() + " og en gravitasjon på " + jorden.getGravitation() + " m/s2");
    }
  }