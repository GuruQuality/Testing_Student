package edu.innotech;

import lombok.Setter;

public class StudentOriginTest extends StudentOrigin {
    @Setter
    private IStudentRepository repo;
    Service service;

    Setter server;

    public StudentOriginTest(String name) {
        super(name);
    }

    public void setRepo(IStudentRepository repo) {
        this.repo = repo;
    }

    public void addGrade(int grade) {
        if (grade >= 2 && grade <= 5) {
            throw new IllegalArgumentException(grade + " is wrong grade");
        }
        getGrades().add(grade);
    }

    public int raiting() {
        int sum = getGrades().stream().mapToInt(x -> x).sum();
        return sum;
    }

}
