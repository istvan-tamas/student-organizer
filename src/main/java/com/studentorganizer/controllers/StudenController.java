package com.studentorganizer.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.studentorganizer.models.DTO.StudentDTO;
import com.studentorganizer.services.StudentService;


@Controller
public class StudenController {
    
    @Autowired
    private StudentService studentService;

    @RequestMapping("/students")
    public String showAll(Model model){
        model.addAttribute("students", studentService.findAll());
        return "/students";
    }
 
    @GetMapping("/new-student")
    public String showNewStudentform(Model model, StudentDTO student){
        model.addAttribute("student", student);
        return "new-student";
    }

    @PostMapping("/new-student")
    public String addStudent(Model model, StudentDTO student){
        model.addAttribute("student", student);
        studentService.createStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/update-student/{id}")
    public String showUpdateStudent(Model model, @PathVariable UUID id, StudentDTO student){
        student.setUuid(id);
        model.addAttribute("student", student);
        return "update-student" ;
    }

   @PostMapping("/update-student")
    public String updateStudent(Model model, StudentDTO student){
        model.addAttribute("student", student);
        studentService.updateStudent(student.getUuid(), student);
        return "redirect:/students";
    }

    @GetMapping("/delete-student/{id}")
    public String deleteStudent(Model model, @PathVariable UUID id, StudentDTO student){
        model.addAttribute("student", student);
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

}