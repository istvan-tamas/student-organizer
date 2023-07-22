package com.studentorganizer.interfaces;

import com.studentorganizer.models.DTO.StudentDTO;

public interface StudentCRUDInterface {
    void createStudent(String neptune, String firstName, String lastName, String major, String educationType);

    StudentDTO readStudent(int index);

    void updateStudent(String neptune, String firstName, String lastName, String major, String educationType, int index);

    public void deleteStudent(int index);

}
