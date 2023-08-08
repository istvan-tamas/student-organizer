package com.studentorganizer.interfaces;

import java.util.List;

import com.studentorganizer.models.Student;

public interface StudentCRUDInterface {
    public void addStudent(Student student);

    public List<Student> findAll();

    public String updateStudent(String id, Student student);

    public void deleteStudent(String id);

    public Student getStudent(String id);

    public String findStudentById(String id, String student);

}