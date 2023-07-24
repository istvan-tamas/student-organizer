package com.studentorganizer.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.studentorganizer.interfaces.StudentCRUDInterface;
import com.studentorganizer.models.DTO.StudentDTO;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentCRUDInterface {

    private List<StudentDTO> students = new ArrayList<>(Arrays.asList(
        new StudentDTO("HRBOFJ", "Ronald", "McDonald","PTI","correspondance"),
        new StudentDTO("ASD123", "Guy", "Johnson","MTI","full-time")
     )
    );

    @Override
    public StudentDTO createStudent(StudentDTO student) {
        students.add(student);
        return student;
    }

    @Override
    public List<StudentDTO> findAll() {
        return students;
    }

    @Override
    public void updateStudent(UUID id, StudentDTO student) {
        for(int i = 0; i< students.size(); i++){
            StudentDTO s = students.get(i);
            if(s.getUuid().equals(id)){
                students.set(i, student);
                return;
            }
        }
    }

    @Override
    public int deleteStudent(UUID id) {
        students.removeIf(t -> t.getUuid().equals(id));
        return 0;
    }

    @Override
    public StudentDTO getStudent(UUID id){
        return students.stream().filter(t -> t.getUuid().equals(id)).findFirst().get();
    }
    
}
