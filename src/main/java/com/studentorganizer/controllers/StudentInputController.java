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
    
    @Autowired
    private StudentService studentService;

    @PostMapping("/student-input")
        void studentSubmit(@ModelAttribute StudentDTO student, Model model) {
        studentService.createStudent(student.getNeptune(), student.getFirstName(), student.getLastName(), student.getMajor(), student.getEducationType());
    }

    @GetMapping("/all")
    public String showAll(Model model){
        model.addAttribute("students", studentService.findAll());
        return "/students/allStudents";
    }


    
  }
    //@PutMapping("")
    //@DeleteMapping
