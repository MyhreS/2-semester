 
 public class Main {

    public static void main(String[] args) {
        Student nikolaTesla = new Student();

        nikolaTesla.fornavn = "Nikola";
        nikolaTesla.etternavn = "Tesla";
        nikolaTesla.alder = 59;

        nikolaTesla.printStudentInformasjon();

        Student larsEmil = new Student();

        larsEmil.fornavn = "Lars Emil";
        larsEmil.etternavn = "Knudsen";
        larsEmil.alder = 32;

        larsEmil.printStudentInformasjon();
    }

 }