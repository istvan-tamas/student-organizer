package com.studentorganizer.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
}

    
    //@PutMapping("")
    //@DeleteMapping
