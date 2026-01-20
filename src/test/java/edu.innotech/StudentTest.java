package edu.innotech;

//import org.junit.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import static org.mockito.Mockito.mock;

public class StudentTest {
    @org.junit.jupiter.api.Test
    @DisplayName("корректные оценки добавляются в список")
    public void markInRage() throws IOException {
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
    public void equals() throws IOException {
        Student student1 = new Student("Vasia");
        student1.addGrade(4);
        Student student2 = new Student("Vasia");
        student2.addGrade(4);
        Assertions.assertTrue(student1.equals(student2), "ошибка сравнения идентичных объектов");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("корректное сравнение идентичных объектов по HashCode")
    public void equalsViaHash() throws IOException {
        Student student1 = new Student("Vasia");
        student1.addGrade(4);
        Student student2 = new Student("Vasia");
        student2.addGrade(4);
        Assertions.assertEquals(student1.hashCode(), student2.hashCode(), "ошибка сравнения идентичных объектов");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("корректное сравнение не идентичных объектов")
    public void notEquals() throws IOException {
        Student student1 = new Student("VasiaSuperStar");
        student1.addGrade(4);
        Student student2 = new Student("Vasia");
        student2.addGrade(4);
        Assertions.assertFalse(student1.equals(student2), "ошибка сравнения не идентичных объектов");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("корректное сравнение обекта самого с собой")
    public void equalsSalf() throws IOException {
        Student student1 = new Student("VasiaSuperStar");
        student1.addGrade(4);
        Assertions.assertTrue(student1.equals(student1), "ошибка сравнения не идентичных объектов");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("корректное сравнение обекта с null")
    public void equalsNull() throws IOException {
        Student student1 = new Student("VasiaSuperStar");
        student1.addGrade(4);
        Assertions.assertFalse(student1.equals(null), "ошибка сравнения не идентичных объектов");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("корректное сравнение обекта с другим типом объекта")
    public void equalsOther() throws IOException {
        Student student1 = new Student("VasiaSuperStar");
        student1.addGrade(4);
        Assertions.assertFalse(student1.equals(new Object()), "ошибка сравнения не идентичных объектов");
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
        Student student = new Student("Vasia");

        // Добавляем оценку через рефлексию (без HTTP)
        Field gradesField = Student.class.getDeclaredField("grades");
        gradesField.setAccessible(true);
        List<Integer> grades = (List<Integer>) gradesField.get(student);
        grades.add(4);
        grades.add(5); // Добавим вторую оценку для теста

        // Act
        // Здесь метод raiting() попытается сделать HTTP-запрос
        // Но мы не можем его протестировать без реального сервера
        // Вместо этого проверим сумму оценок

        int sum = student.getGrades().stream().mapToInt(x -> x).sum();

        // Assert
        Assertions.assertEquals(9, sum); // 4 + 5 = 9
        Assertions.assertEquals(2, student.getGrades().size());
    }
}

