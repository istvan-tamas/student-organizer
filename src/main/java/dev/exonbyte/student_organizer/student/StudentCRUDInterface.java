package dev.exonbyte.student_organizer.student;

import java.util.List;

import dev.exonbyte.student_organizer.student.Student;
import dev.exonbyte.student_organizer.student.StudentDTO;

public interface StudentCRUDInterface {
    public String addStudent(StudentDTO student);

    public List<Student> findAll(int pageNumber, int pageSize);

    public String updateStudent(Student student);

    public String deleteStudent(String id);

    public Student getStudentById(String id);

}
