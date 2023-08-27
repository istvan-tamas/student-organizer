package com.studentorganizer.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.studentorganizer.interfaces.StudentCRUDInterface;
import com.studentorganizer.models.Student;
import com.studentorganizer.models.DTO.StudentDTO;

import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentCRUDInterface {

    private List<Student> students = new ArrayList<>(Arrays.asList(
        new Student("790758", "Joye", "Braunle","PTI","full-time",UUID.randomUUID().toString()),
        new Student("401953", "Eryn", "Delouch","PTI","part-time",UUID.randomUUID().toString()),
        new Student("769424", "Kale", "Dougliss","GI","part-time",UUID.randomUUID().toString()),
        new Student("431590", "Marlo", "Edwinson","MI","full-time",UUID.randomUUID().toString()),
        new Student("781693", "Lorry", "Hardwich","PTI","full-time",UUID.randomUUID().toString())
     )
    );

    @Override
    public String addStudent(Student student) {
        student.setUuid(UUID.randomUUID().toString());
        students.add(student);
        return "Student added OK!";
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public String updateStudent(String id, Student student) {
        students.set(students.indexOf(getStudent(id)),student);
        return "Student updated OK!";
        
    }

    @Override
    public String deleteStudent(String id) {
        students.removeIf(t -> t.getUuid().equals(id));
        return "Student deleted OK!";
    }

    @Override
    public Student getStudent(String id){
        return students.stream().filter(t -> t.getUuid().equals(id)).findFirst().get();
    }
    
}
