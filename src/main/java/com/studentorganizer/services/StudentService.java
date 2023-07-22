package com.studentorganizer.services;

import java.util.List;

import com.studentorganizer.interfaces.StudentCRUDInterface;
import com.studentorganizer.models.DTO.StudentDTO;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentCRUDInterface {

    List<StudentDTO> students;

    @Override
    public void createStudent(String neptune, String firstName, String lastName, String major, String educationType) {
        StudentDTO student = new StudentDTO(neptune, firstName, lastName, major, educationType);
        students.add(student);
    }

    @Override
    public StudentDTO readStudent(int index) {
        return students.get(index);
    }

    @Override
    public void updateStudent(String neptune, String firstName, String lastName, String major, String educationType, int index) {
        StudentDTO updated_student = new StudentDTO(neptune, firstName, lastName, major, educationType);
        students.set(index, updated_student);
    }

    @Override
    public void deleteStudent(int index) {
        students.remove(index);
    }
    
}
