package com.studentorganizer.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class HealthController {
    @GetMapping("/health")
    String returnStatus(){
        return "OK";
    }
}
