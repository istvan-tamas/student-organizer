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

 //   @RequestMapping("/students")
 //   public List<StudentDTO> getAllStudents(){
 //       return studentService.findAll();
 //   }

    @RequestMapping("/students")
    public String showAll(Model model){
        model.addAttribute("students", studentService.findAll());
        return "/students";
    }

    @RequestMapping("/students/{id}")
    public StudentDTO getStudent(@PathVariable UUID id){
        return studentService.getStudent(id);
    }

 //   @RequestMapping(method=RequestMethod.POST, value = "/students")
 //   public void addStudent(@RequestBody StudentDTO student){
 //       studentService.createStudent(student);
 //   }
 
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
    public String updateStudent(Model model, @PathVariable UUID id, StudentDTO student){
        studentService.updateStudent(id, student);
        model.addAttribute("student", studentService.updateStudent(id, student));
        return "update-student" ;
    }

//   @RequestMapping(method=RequestMethod.DELETE, value = "/students/{id}")
//    public void deleteStudent(@PathVariable UUID id){
//        studentService.deleteStudent(id);
//    }

    @GetMapping("/delete-student/{id}")
    public String deleteStudent(Model model, @PathVariable UUID id){
        model.addAttribute("student", studentService.deleteStudent(id));
        return "redirect:/students";
    }

}