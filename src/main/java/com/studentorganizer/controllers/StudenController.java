package com.studentorganizer.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(method=RequestMethod.POST, value = "/students")
    public String addStudent(Model model, @RequestBody StudentDTO student){
        model.addAttribute("student", studentService.createStudent(student));
        return "/students";
    }

    @RequestMapping(method=RequestMethod.PUT, value = "/students/{id}")
    public void updateStudent(@RequestBody StudentDTO student, @PathVariable UUID id){
        studentService.updateStudent(id, student);
    }

    @RequestMapping(method=RequestMethod.DELETE, value = "/students/{id}")
    public void deleteStudent(@PathVariable UUID id){
        studentService.deleteStudent(id);
    }
}

    
    //@PutMapping("")
    //@DeleteMapping
