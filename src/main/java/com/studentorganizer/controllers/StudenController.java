package com.studentorganizer.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.studentorganizer.models.DTO.StudentDTO;
import com.studentorganizer.services.StudentService;


@RestController
public class StudenController {
    
    @Autowired
    private StudentService studentService;

    @RequestMapping("/students")
    public List<StudentDTO> getAllStudents(){
        return studentService.findAll();
    }

    @RequestMapping("/students/{id}")
    public StudentDTO getStudent(@PathVariable UUID id){
        return studentService.getStudent(id);
    }

    @RequestMapping(method=RequestMethod.POST, value = "/students")
    public void addStudent(@RequestBody StudentDTO student){
        studentService.createStudent(student);
    }

    @RequestMapping(method=RequestMethod.PUT, value = "/students/{id}")
    public void updateStudent(@RequestBody StudentDTO student, @PathVariable UUID id){
        studentService.updateStudent(id, student);
    }
}

    
    //@PutMapping("")
    //@DeleteMapping
