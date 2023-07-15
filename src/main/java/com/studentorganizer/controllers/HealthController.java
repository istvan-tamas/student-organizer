package com.studentorganizer.controllers;
import org.springframework.web.bind.annotation.RestController;

import com.studentorganizer.models.DTO.HealthDTO;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HealthController {
    @GetMapping("/health")
    HealthDTO returnStatus(){
        return new HealthDTO();
    }
}
