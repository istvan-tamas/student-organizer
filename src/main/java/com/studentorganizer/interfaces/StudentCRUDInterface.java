package com.studentorganizer.interfaces;

import java.util.List;

import com.studentorganizer.models.DTO.StudentDTO;

public interface StudentCRUDInterface {
    void createStudent(String neptune, String firstName, String lastName, String major, String educationType);

    public List<StudentDTO> findAll();

    void updateStudent(String neptune, String firstName, String lastName, String major, String educationType, int index);

    public void deleteStudent(int index);

}