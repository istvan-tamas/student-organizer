package com.studentorganizer.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.studentorganizer.models.DTO.StudentDTO;


@Controller
public class StudentInputController {
    
    @GetMapping("/student-input")
    public String addStudentForm(Model model) {
        model.addAttribute("input", new StudentDTO());
        return "student-input";
    }

    @PostMapping("/student-input")
        public String studentSubmit(@ModelAttribute StudentDTO student, Model model) {
        model.addAttribute("student", student);
        return "submission-result";
  }

}
