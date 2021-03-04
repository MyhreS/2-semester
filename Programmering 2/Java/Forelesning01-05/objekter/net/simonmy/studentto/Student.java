package net.simonmy.studentto;

public class Student {
    private String fornavn, etternavn, fodselsnummer;

    public Student(String fornavn, String etternavn, String fodselsnummer){
        this.fornavn = "Tom Heine";
        this.etternavn = "Natt";
        this.fodselsnummer = "32223332";
    }

    public void printStudentInfo() {
        System.out.println(fornavn + " " + etternavn);
    }
}