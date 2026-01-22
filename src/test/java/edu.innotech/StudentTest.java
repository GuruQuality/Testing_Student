package edu.innotech;

//import org.junit.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import static org.mockito.Mockito.mock;

public class StudentTest {
    @org.junit.jupiter.api.Test
    @DisplayName("корректные оценки добавляются в список")
    public void rightGrade() throws IOException {
        Student student = new Student("Vasia");
        Service serviceMock = mock(Service.class);
        Mockito.when(serviceMock.checkGrade(5)).thenReturn(true);
        student.setService(serviceMock);
        Assertions.assertDoesNotThrow(() -> student.addGrade(5));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("не корректные оценки не добавляются в список")
    public void wrongGrade() throws IOException {
        Student student = new Student("Vasia");
        Service serviceMock = mock(Service.class);
        Mockito.when(serviceMock.checkGrade(5)).thenReturn(false);
        student.setService(serviceMock);
        Assertions.assertThrows(IllegalArgumentException.class, () -> student.addGrade(5));
    }
}


