package com.studentorganizer.interfaces;

import java.util.List;

import com.studentorganizer.models.Student;

public interface StudentCRUDInterface {
    public String addStudent(Student student);

    public List<Student> findAll();

    public void updateStudent(String id, Student student);

    public String deleteStudent(String id);

    public Student getStudentbyId(String id);

}