
public class Planet {

    //variabler
    private String name;
    private double radius;
    private double gravitation;


    public Planet() {

    }
    //Konstruktør
    public Planet(String name, double radius, double gravitation) {
      this.name = name;
      this.radius = radius;
      this.gravitation = gravitation;
    }

    //get
    public String getName() {
      return name;
    }
  
    public double getRadius() {
      return radius;
    }
  
    public double getGravitation() {
      return gravitation;
    }
  
    //set
    public void setName(String name) {
      this.name = name;

    }
  
    public void setRadius(double radius) {
      this.radius = radius;
    }
  
    public void setGravitation(double gravitation) {
      this.gravitation = gravitation;
    }
  }