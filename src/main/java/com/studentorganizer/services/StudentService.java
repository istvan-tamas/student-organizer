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
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public String updateStudent(String id, Student student) {
        this.findStudentById(id, student);
        
    }

    @Override
    public void deleteStudent(String id) {
        students.removeIf(t -> t.getUuid().equals(id));
    }

    @Override
    public Student getStudent(String id){
        return students.stream().filter(t -> t.getUuid().equals(id)).findFirst().get();
    }

    @Override
    public String findStudentById(String id, Student student){
        for (int counter = 0; counter < students.size(); counter++) { 		      
            if(student.uuid == id){
                return id;
            }		
        } 
    }
    
}
