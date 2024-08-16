package dev.exonbyte.student_organizer.controllers;

import dev.exonbyte.student_organizer.DTO.StudentDTO;
import dev.exonbyte.student_organizer.DTO.StudentResponse;
import dev.exonbyte.student_organizer.models.Student;
import dev.exonbyte.student_organizer.services.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class StudentController {

    @Autowired
    private StudentServiceImp studentService;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String showAllStudents(Model model,
                                  @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Optional<Integer> page,
                                  @RequestParam(value = "pageSize", defaultValue = "15", required = false) Optional<Integer> size
    ) {
        int pageNumber = page.orElse(0);
        int pageSize = size.orElse(15);

        StudentResponse students = studentService.getAllStudents(pageNumber, pageSize);

        model.addAttribute("students", students);
        model.addAttribute("pageSize", students.getPageSize());
        model.addAttribute("pageNumber", students.getPageNumber());

        return "students";
    }

    @RequestMapping(value = "students/{id}", method = RequestMethod.GET)
    public String showUpdateStudentForm(Model model, @PathVariable Integer id) {

        StudentDTO student = studentService.getStudentById(id);

        model.addAttribute("student", student);

        return "update-student";
    }

    @RequestMapping(value = "students/update/{id}", method = RequestMethod.POST)
    public String updateStudent(StudentDTO student, @PathVariable Integer id) {
        studentService.updateStudent(id, student);
        return "redirect:/students/{id}";
    }

}
