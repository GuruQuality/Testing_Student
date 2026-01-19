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
    @DisplayName("добавление неверных оценок кидает исключение")
    public void marskNotInPange() {
        List<Integer> list = List.of(2, 1, 6, 7);
        Student student = new Student("Vasia");
        //student.addMark(list.get(1));
        //student.addMark(list.get(2));
        //student.addMark(list.get(3));
        //ПРоверка на выпадающее исключение
//        Assertions.assertThrows(IllegalArgumentException.class, () -> student.addMark(list.get(1)));//получаем елимент в листе
//        Assertions.assertDoesNotThrow(() -> student.addMark(3));// тест - не получаем исключение при вызове
        //Assertions.assertThrows(IllegalArgumentException.class, () -> student.addMark(2));
        //Assertions.assertThrows(IllegalArgumentException.class, () -> student.addMark(5));
    }
}
