package com.studentorganizer.interfaces;

import java.util.List;
import java.util.UUID;

import com.studentorganizer.models.DTO.StudentDTO;

public interface StudentCRUDInterface {
    void createStudent(StudentDTO student);

    public List<StudentDTO> findAll();

    public void updateStudent(UUID id, StudentDTO student);

    public void deleteStudent(int index);

    public StudentDTO getStudent(UUID id);

}