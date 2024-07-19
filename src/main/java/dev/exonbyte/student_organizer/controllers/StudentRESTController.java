package dev.exonbyte.student_organizer.controllers;

import dev.exonbyte.student_organizer.DTO.StudentDTO;
import dev.exonbyte.student_organizer.DTO.StudentResponse;
import dev.exonbyte.student_organizer.services.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class StudentRESTController {

    private final StudentServiceImp studentService;

    @Autowired
    public StudentRESTController(StudentServiceImp studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<StudentResponse> getAllStudents(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    )
    {
        return new ResponseEntity<>(studentService.getAllStudents(pageNumber, pageSize), HttpStatus.OK);
    }

    @GetMapping("students/{id}")
    public ResponseEntity<StudentDTO> studentDetail(@PathVariable Integer id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
        return new ResponseEntity<>(studentService.createStudent(studentDTO), HttpStatus.CREATED);
    }

    @PutMapping("students/{id}/update")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Integer id, @RequestBody StudentDTO student) {
        studentService.updateStudent(id,student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("students/{id}/delete")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudentById(id);
    }

    @DeleteMapping("students/purge")
    public void deleteAllStudents(){
        studentService.deleteAllStudents();
    }
}
