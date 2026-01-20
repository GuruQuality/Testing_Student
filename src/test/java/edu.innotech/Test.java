package edu.innotech;

//import org.junit.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

public class Test {
    @org.junit.jupiter.api.Test
    @DisplayName("корректные оценки добавляются в список")
    public void markInRage() {
        Student student = new Student("Vasia");
        student.addGrade(5);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> student.getGrades().add(999));
        for (int grade : student.getGrades()) {
            Assertions.assertTrue(grade >= 2 && grade <= 5, "Не допустимая оценка: " + grade);
        }
    }

    @org.junit.jupiter.api.Test
    @DisplayName("не корректные оценки не добавляются в список")
    public void markNotInRage() {
        Student student = new Student("Vasia");
        Assertions.assertThrows(IllegalArgumentException.class, () -> student.addGrade(999), "Не допустимая оценка добавилась ");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("корректное сравнение идентичных объектов")
    public void equals() {
        Student student1 = new Student("Vasia");
        student1.addGrade(4);
        Student student2 = new Student("Vasia");
        student2.addGrade(4);
        Assertions.assertTrue(student1.equals(student2), "ошибка сравнения идентичных объектов");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("корректное сравнение идентичных объектов по HashCode")
    public void equalsViaHash() {
        Student student1 = new Student("Vasia");
        student1.addGrade(4);
        Student student2 = new Student("Vasia");
        student2.addGrade(4);
        Assertions.assertEquals(student1.hashCode(), student2.hashCode(), "ошибка сравнения идентичных объектов");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("корректное сравнение не идентичных объектов")
    public void notEquals() {
        Student student1 = new Student("VasiaSuperStar");
        student1.addGrade(4);
        Student student2 = new Student("Vasia");
        student2.addGrade(4);
        Assertions.assertFalse(student1.equals(student2), "ошибка сравнения не идентичных объектов");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("корректное сравнение обекта самого с собой")
    public void equalsSalf() {
        Student student1 = new Student("VasiaSuperStar");
        student1.addGrade(4);
        Assertions.assertTrue(student1.equals(student1), "ошибка сравнения не идентичных объектов");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("корректное сравнение обекта с null")
    public void equalsNull() {
        Student student1 = new Student("VasiaSuperStar");
        student1.addGrade(4);
        Assertions.assertFalse(student1.equals(null), "ошибка сравнения не идентичных объектов");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("корректное сравнение обекта с другим типом объекта")
    public void equalsOther() {
        Student student1 = new Student("VasiaSuperStar");
        student1.addGrade(4);
        Assertions.assertFalse(student1.equals(new Object()), "ошибка сравнения не идентичных объектов");
    }
}
