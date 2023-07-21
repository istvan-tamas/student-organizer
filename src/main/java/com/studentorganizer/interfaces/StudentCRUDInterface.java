package com.studentorganizer.interfaces;

public interface StudentCRUDInterface {
    void createStudent(String neptune, String firstName, String lastName, String major, String educationType);

    void readStudent();

    void updateStudent(String neptune, String firstName, String lastName, String major, String educationType);

    void deleteStudent();

}
