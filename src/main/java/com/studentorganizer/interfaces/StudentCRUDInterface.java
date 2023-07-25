package com.studentorganizer.interfaces;

import java.util.List;
import java.util.UUID;

import com.studentorganizer.models.DTO.StudentDTO;

public interface StudentCRUDInterface {
    public void createStudent(StudentDTO student);

    public List<StudentDTO> findAll();

    public StudentDTO updateStudent(UUID id, StudentDTO student);

    public int deleteStudent(UUID id);

    public StudentDTO getStudent(UUID id);

}