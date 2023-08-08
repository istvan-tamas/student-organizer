package com.studentorganizer.interfaces;

import java.util.List;
import java.util.UUID;

import com.studentorganizer.models.Student;
import com.studentorganizer.models.DTO.StudentDTO;

public interface StudentCRUDInterface {
    public void addStudent(Student student);

    public List<Student> findAll();

    public void updateStudent(UUID id, StudentDTO student);

    public void deleteStudent(String id);

    public Student getStudent(String id);

}