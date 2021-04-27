package main.java.github.newtonjose.domain.models;

import java.time.LocalDate;

public class Candidato {
    private String name;
    private char gender;
    private LocalDate bornDate;
    private String jobPosition;
    private String curriculumnResume;
    private int codigo;

    public Candidato() {

    }

    public Candidato(String name, char gender, LocalDate date, String cargo, String resume) {
        this.name = name;
        this.gender = gender;
        this.bornDate = date;
        this.jobPosition = cargo;
        this.curriculumnResume = resume;
    }

    public String getName() {
        return this.name;
    }

    public char getGender() {
        return this.gender;
    }

    public LocalDate getBornDate() {
        return this.bornDate;
    }

    public String getJobPosition() {
        return this.jobPosition;
    }

    public String getCurriculumResume() {
        return this.curriculumnResume;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo() {
        return this.codigo;
    }
}
