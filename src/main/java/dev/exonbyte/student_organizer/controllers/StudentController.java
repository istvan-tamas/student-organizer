package dev.exonbyte.student_organizer.controllers;

import dev.exonbyte.student_organizer.DTO.StudentDTO;
import dev.exonbyte.student_organizer.DTO.StudentResponse;
import dev.exonbyte.student_organizer.services.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
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
                                  @RequestParam(value = "pageSize", defaultValue = "20", required = false) Optional<Integer> size
    ) {
        int pageNumber = page.orElse(0);
        int pageSize = size.orElse(20);

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

    @RequestMapping(value = "students/new-student", method = RequestMethod.GET)
    public String showCreateStudentForm(Model model, @ModelAttribute StudentDTO student) {
        model.addAttribute("student", student);
        return "new-student";
    }

    @RequestMapping(value = "students/add-new-student", method = RequestMethod.POST)
    public String createNewStudent(StudentDTO student) {
        studentService.createStudent(student);
        return "redirect:/students";
    }

    @RequestMapping(value = "students/update/{id}", method = RequestMethod.POST)
    public String updateStudent(StudentDTO student, @PathVariable Integer id) {
        studentService.updateStudent(id, student);
        return "redirect:/students/{id}";
    }

    @RequestMapping(value = "students/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }

}
