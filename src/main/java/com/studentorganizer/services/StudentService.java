package com.studentorganizer.services;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import com.studentorganizer.interfaces.StudentCRUDInterface;
import com.studentorganizer.models.Student;
import com.studentorganizer.models.DTO.StudentDTO;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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


    // ez már nem teljesen CRUD interfész, külön interfészbe kellene rakni, vagy maradjon így?

    public Page<Student> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Student> list;

        if (students.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, students.size());
            list = students.subList(startItem, toIndex);
        }

        Page<Student> studentPage
          = new PageImpl<Student>(list, PageRequest.of(currentPage, pageSize), students.size());

        return studentPage;
    }

}



