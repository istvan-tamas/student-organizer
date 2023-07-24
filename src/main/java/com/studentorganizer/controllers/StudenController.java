package com.studentorganizer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

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
}

    
    //@PutMapping("")
    //@DeleteMapping
