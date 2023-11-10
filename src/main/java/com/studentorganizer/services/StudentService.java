package com.studentorganizer.services;

import java.util.List;
import java.util.UUID;

import com.studentorganizer.interfaces.StudentCRUDInterface;
import com.studentorganizer.models.Student;
import com.studentorganizer.models.DTO.StudentDTO;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentCRUDInterface {

    private List<Student> students = DeployService.records;

    @Override
    public String addStudent(StudentDTO student) {
        Student newStudent = new Student(student.getNeptune(), student.getFirstName(), student.getLastName(), student.getMajor(), student.getEducationType(), UUID.randomUUID().toString());
        students.add(newStudent);
        return "Student added OK!";
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public String updateStudent(Student student) {
        Student updateStudent = new Student(student.getNeptune(), student.getFirstName(), student.getLastName(), student.getMajor(), student.getEducationType(), student.getUuid());
        students.set(students.indexOf(getStudentbyId(student.getUuid())),updateStudent);
        return "Student update OK";

    }

    @Override
    public String deleteStudent(String id) {
        students.removeIf(t -> t.getUuid().equals(id));
        return "Student deleted OK!";
    }

    @Override
    public Student getStudentbyId(String id){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getUuid().equals(id)) {
                return students.get(i);
            }
        }
        return null;
        }
    }
