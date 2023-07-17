package com.studentorganizer.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.studentorganizer.services.LogService;


@Controller
public class StudentInputController {
    
    @Autowired
    private LogService logService;
    
    @GetMapping("/student-input")
    public void status() {
        logService.log();
    }
}
