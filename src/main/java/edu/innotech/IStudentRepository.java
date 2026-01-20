package edu.innotech;

public interface IStudentRepository {
    default boolean getRaintingStudents(int gade) {
        return false;
    }
}
