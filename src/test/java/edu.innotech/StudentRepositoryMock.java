package edu.innotech;

public class StudentRepositoryMock {
    public int getRaintingStudents(int gade) {
        return 5;
    }

    // Метод для расчета рейтинга в тестах
    public int calculateRating(int sum) {
        // Простая логика для тестов
        return sum * 10;
    }
}
