package com.studentorganizer.interfaces;

import java.util.List;

import com.studentorganizer.models.Student;
import com.studentorganizer.models.DTO.StudentDTO;

public interface StudentCRUDInterface {
    public String addStudent(Student student);

    public List<Student> findAll();

    public String updateStudent(String id, Student student);

    public String deleteStudent(String id);

    public Student getStudent(String id);

}