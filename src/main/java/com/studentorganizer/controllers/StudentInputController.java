package com.studentorganizer.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.studentorganizer.models.DTO.StudentDTO;
import com.studentorganizer.services.StudentService;


@Controller
public class StudentInputController {
    
    @GetMapping("/student-input")
    public String addStudentForm(Model model) {
        model.addAttribute("input", new StudentDTO());
        return "student-input";
    }

    @Autowired
    private StudentService studentService;

    @PostMapping("/student-input")
        public String studentSubmit(@ModelAttribute StudentDTO student, Model model) {
        studentService.createStudent(student.getNeptune(), student.getFirstName(), student.getLastName(), student.getMajor(), student.getEducationType());
        return "submission-result";
  }

}