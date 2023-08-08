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
        new StudentDTO("790758", "Joye", "Braunle","PTI","full-time",UUID.randomUUID()),
        new StudentDTO("401953", "Eryn", "Delouch","PTI","part-time",UUID.randomUUID()),
        new StudentDTO("769424", "Kale", "Dougliss","GI","part-time",UUID.randomUUID()),
        new StudentDTO("431590", "Marlo", "Edwinson","MI","full-time",UUID.randomUUID()),
        new StudentDTO("781693", "Lorry", "Hardwich","PTI","full-time",UUID.randomUUID())
     )
    );

    @Override
    public void createStudent(StudentDTO student) {
        student.setUuid(UUID.randomUUID());
        students.add(student);
        return;
    }

    @Override
    public List<StudentDTO> findAll() {
        return students;
    }

    @Override
    public void updateStudent(UUID id, StudentDTO student) {
        for(int i = 0; i < students.size(); i++){
            // find student by id
            StudentDTO s = students.get(i);   
            if(s.getUuid().equals(id)){
                students.set(i, student);
                //ellenőrzés, hogy az update sikerült-e
                // Student DTO == nem nulla-e

                // ha nem sikerült az update, akkkor hibaüzenet
                // küldje vissza az id-t string-ben
                return;
            }
        }
    }

    @Override
    public void deleteStudent(UUID id) {
        students.removeIf(t -> t.getUuid().equals(id));
    }

    @Override
    public StudentDTO getStudent(UUID id){
        return students.stream().filter(t -> t.getUuid().equals(id)).findFirst().get();
    }
    
}
