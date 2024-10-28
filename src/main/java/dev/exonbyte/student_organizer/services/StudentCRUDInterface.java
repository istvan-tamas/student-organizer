package dev.exonbyte.student_organizer.services;

import dev.exonbyte.student_organizer.DTO.StudentDTO;
import dev.exonbyte.student_organizer.DTO.StudentResponse;

public interface StudentCRUDInterface {
    StudentDTO createStudent(StudentDTO studentDTO);
    StudentResponse getAllStudents(int pageNumber, int pageSize);
    StudentDTO getStudentById(int id);
    void updateStudent(int id, StudentDTO studentDTO);
    void deleteStudentById(int id);
    void deleteAllStudents();
}
