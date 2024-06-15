package dev.exonbyte.student_organizer.student;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dev.exonbyte.student_organizer.deployment.DeploymentService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentCRUDInterface {

    private final List<Student> students = DeploymentService.records;

    @Override
    public String addStudent(StudentDTO student) {
        Student newStudent = new Student(student.getNeptune(), student.getFirstName(), student.getLastName(), student.getMajor(), student.getEducationType(), UUID.randomUUID().toString());
        students.add(newStudent);
        return "Student added OK!";
    }

    @Override
    public List<Student> findAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        List<Student> students = studentRepository.findAll(pageable);
        List<Student> listOfStudents = students.getContent();
        return students.stream().map(s -> mapToDto(p)).collect(Collerctors.toList());
    }

    @Override
    public String updateStudent(Student student) {
        Student updateStudent = new Student(student.getNeptune(), student.getFirstName(), student.getLastName(), student.getMajor(), student.getEducationType(), student.getUuid());
        students.set(students.indexOf(getStudentById(student.getUuid())),updateStudent);
        return "Student update OK";

    }

    @Override
    public String deleteStudent(String id) {
        students.removeIf(t -> t.getUuid().equals(id));
        return "Student deleted OK!";
    }

    @Override
    public Student getStudentById(String id){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getUuid().equals(id)) {
                return students.get(i);
            }
        }
        return null;
    }

}

