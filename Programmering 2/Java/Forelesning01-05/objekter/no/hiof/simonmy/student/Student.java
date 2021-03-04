package no.hiof.simonmy.student;

public class Student {
    private String fornavn;
    private String etternavn;
    private int alder;
    private String studentId;
    private String fodselsnummer;

    public Student() {

    }

    public Student(String fornavn, String etternavn, String studentId, String fodselsnummer) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.studentId = studentId;
        this.fodselsnummer = fodselsnummer;
    }









    public String getFornavn() {
        return fornavn;
    }
    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }
    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public int getAlder() {
        return alder;
    }
    public void setAlder(int alder) {
        this.alder = alder;
    }

    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFodselsnummer() {
        return fodselsnummer;
    }



    public void printStudentInfo() {
        System.out.println(fornavn + " " + etternavn + " " + alder + " år ID:" + studentId + " " + fodselsnummer);
    }
}