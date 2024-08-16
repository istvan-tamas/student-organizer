package dev.exonbyte.student_organizer.services;

import dev.exonbyte.student_organizer.DTO.StudentDTO;
import dev.exonbyte.student_organizer.DTO.StudentResponse;
import dev.exonbyte.student_organizer.exceptions.StudentNotFoundException;
import dev.exonbyte.student_organizer.models.Student;
import dev.exonbyte.student_organizer.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImp implements StudentCRUDInterface {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentServiceImp(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {

        Student student = mapToStudent(studentDTO);
        studentRepo.save(student);

        return mapToDTO(student);
    }

    @Override
    public StudentResponse getAllStudents(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Student> students = studentRepo.findAll(pageable);
        List<Student> listOfStudents = students.getContent();
        List<StudentDTO> content = listOfStudents.stream().map(s -> mapToDTO(s)).collect(Collectors.toList());

        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setContent(content);
        studentResponse.setPageNumber(students.getNumber());
        studentResponse.setPageSize(students.getSize());
        studentResponse.setTotalElements(students.getTotalElements());

        studentResponse.setTotalPages(students.getTotalPages());
        studentResponse.setLast(students.isLast());

        return studentResponse;
    }

    @Override
    public StudentDTO getStudentById(int id) {
        Student student = studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found"));
        return mapToDTO(student);
    }

    @Override
    public void updateStudent(int id, StudentDTO studentDTO) {
        Student student = studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found, could not be updated"));
        student = mapToStudent(studentDTO);
        Student updatedStudent = studentRepo.save(student);
    }


    @Override
    public void deleteStudentById(int id) {
        studentRepo.deleteById(id);
        System.out.println("Deleted OK");
    }

    @Override
    public void deleteAllStudents() {
        studentRepo.deleteAll();
        System.out.println("Deleted all students OK");
    }

    private StudentDTO mapToDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setNeptune(student.getNeptune());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setMajor(student.getMajor());
        studentDTO.setEducationType(student.getEducationType());

        return studentDTO;
    }

    private Student mapToStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setNeptune(studentDTO.getNeptune());
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setMajor(studentDTO.getMajor());
        student.setEducationType(studentDTO.getEducationType());
        return student;
    }
}
