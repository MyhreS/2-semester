package no.hiof.simonmy.student;

import net.simonmy.studentto.Student;

public class Main {

    public static void main(String[] args) {
        Student nikolaTesla = new Student();

        nikolaTesla.setFornavn("Nikola");
        nikolaTesla.setEtternavn("Tesla");
        nikolaTesla.setAlder(86);
        nikolaTesla.setStudentId("IT765324");

        nikolaTesla.printStudentInfo();

        Student thomasEdison = new Student("Thomas", "Edison", "232432", "111366123");

        thomasEdison.printStudentInfo();
    }

}