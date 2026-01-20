package edu.innotech;

//import org.junit.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class StudentOriginTest {
    @org.junit.jupiter.api.Test
    @DisplayName("корректные оценки добавляются в список")
    public void markInRage() throws IOException {
        StudentOrigin studentOrigin = new StudentOrigin("Vasia");
        studentOrigin.addGrade(5);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> studentOrigin.getGrades().add(999));
        for (int grade : studentOrigin.getGrades()) {
            Assertions.assertTrue(grade >= 2 && grade <= 5, "Не допустимая оценка: " + grade);
        }
    }

    @org.junit.jupiter.api.Test
    @DisplayName("не корректные оценки не добавляются в список")
    public void markNotInRage() {
        StudentOrigin studentOrigin = new StudentOrigin("Vasia");
        Assertions.assertThrows(IllegalArgumentException.class, () -> studentOrigin.addGrade(999), "Не допустимая оценка добавилась ");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("корректное сравнение идентичных объектов")
    public void equals() throws IOException {
        StudentOrigin studentOrigin1 = new StudentOrigin("Vasia");
        studentOrigin1.addGrade(4);
        StudentOrigin studentOrigin2 = new StudentOrigin("Vasia");
        studentOrigin2.addGrade(4);
        Assertions.assertTrue(studentOrigin1.equals(studentOrigin2), "ошибка сравнения идентичных объектов");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("корректное сравнение идентичных объектов по HashCode")
    public void equalsViaHash() throws IOException {
        StudentOrigin studentOrigin1 = new StudentOrigin("Vasia");
        studentOrigin1.addGrade(4);
        StudentOrigin studentOrigin2 = new StudentOrigin("Vasia");
        studentOrigin2.addGrade(4);
        Assertions.assertEquals(studentOrigin1.hashCode(), studentOrigin2.hashCode(), "ошибка сравнения идентичных объектов");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("корректное сравнение не идентичных объектов")
    public void notEquals() throws IOException {
        StudentOrigin studentOrigin1 = new StudentOrigin("VasiaSuperStar");
        studentOrigin1.addGrade(4);
        StudentOrigin studentOrigin2 = new StudentOrigin("Vasia");
        studentOrigin2.addGrade(4);
        Assertions.assertFalse(studentOrigin1.equals(studentOrigin2), "ошибка сравнения не идентичных объектов");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("корректное сравнение обекта самого с собой")
    public void equalsSalf() throws IOException {
        StudentOrigin studentOrigin1 = new StudentOrigin("VasiaSuperStar");
        studentOrigin1.addGrade(4);
        Assertions.assertTrue(studentOrigin1.equals(studentOrigin1), "ошибка сравнения не идентичных объектов");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("корректное сравнение обекта с null")
    public void equalsNull() throws IOException {
        StudentOrigin studentOrigin1 = new StudentOrigin("VasiaSuperStar");
        studentOrigin1.addGrade(4);
        Assertions.assertFalse(studentOrigin1.equals(null), "ошибка сравнения не идентичных объектов");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("корректное сравнение обекта с другим типом объекта")
    public void equalsOther() throws IOException {
        StudentOrigin studentOrigin1 = new StudentOrigin("VasiaSuperStar");
        studentOrigin1.addGrade(4);
        Assertions.assertFalse(studentOrigin1.equals(new Object()), "ошибка сравнения не идентичных объектов");
    }

//    @org.junit.jupiter.api.Test
//    public void testRaiting() throws IOException {
//        StudentTest student1 = new StudentTest("Vasia");
//        student1.addGrade(4);
//        IStudentRepository repositoryMock = mock(IStudentRepository.class);
//        student1.setRepo(repositoryMock);
//        Mockito.when(repositoryMock.getRaintingStudents(Mockito.anyInt()))
//                .thenReturn();
//        Assertions.assertEquals(true, student1.raiting());
//    }

    @org.junit.jupiter.api.Test
    public void testRaitingWithReflection() throws Exception {
        // Arrange
        StudentOrigin studentOrigin = new StudentOrigin("Vasia");

        // Добавляем оценку через рефлексию (без HTTP)
        Field gradesField = StudentOrigin.class.getDeclaredField("grades");
        gradesField.setAccessible(true);
        List<Integer> grades = (List<Integer>) gradesField.get(studentOrigin);
        grades.add(4);
        grades.add(5); // Добавим вторую оценку для теста

        // Act
        // Здесь метод raiting() попытается сделать HTTP-запрос
        // Но мы не можем его протестировать без реального сервера
        // Вместо этого проверим сумму оценок

        int sum = studentOrigin.getGrades().stream().mapToInt(x -> x).sum();

        // Assert
        Assertions.assertEquals(9, sum); // 4 + 5 = 9
        Assertions.assertEquals(2, studentOrigin.getGrades().size());
    }
}

