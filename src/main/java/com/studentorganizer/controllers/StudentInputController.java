package com.studentorganizer.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.studentorganizer.models.DTO.StudentDTO;


@Controller
public class StudentInputController {
    @GetMapping("/student-input")
    public String inputForm(Model model){
        model.addAttribute("student-input", new StudentDTO());
        return "student-input";
    }
}
