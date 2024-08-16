package dev.exonbyte.student_organizer.controllers;

import dev.exonbyte.student_organizer.DTO.StudentResponse;
import dev.exonbyte.student_organizer.services.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Controller
public class StudentController {

    @Autowired
    private StudentServiceImp studentService;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String showAllStudents(Model model,
                                  @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Optional<Integer> page,
                                  @RequestParam(value = "pageSize", defaultValue = "25", required = false) Optional<Integer> size
    ) {
        int pageNumber = page.orElse(0);
        int pageSize = size.orElse(25);

        StudentResponse students = studentService.getAllStudents(pageNumber, pageSize);

        model.addAttribute("students", students);
        model.addAttribute("pageSize", students.getPageSize());
        model.addAttribute("pageNumber", students.getPageNumber());

        return "students";
    }


}
