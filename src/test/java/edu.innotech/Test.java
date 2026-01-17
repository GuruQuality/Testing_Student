package edu.innotech;

//import org.junit.Test;

import org.junit.jupiter.api.DisplayName;

import java.util.List;

public class Test {
    @org.junit.jupiter.api.Test
    @DisplayName("корректные оценки добавляются в список")
    public void markInRage() {
        List<Integer> list = List.of(2, 3, 4, 5);
        Student student = new Student("Vasia");
        //Assertions.assertEquals(list, student.getMark(), "test error");
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
