package com.studentorganizer.controller;
import org.springframework.web.bind.annotation.RestController;

import com.studentorganizer.model.DTO.HealthDTO;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HealthController {
    @GetMapping("/health")
    HealthDTO returnStatus(){
        return new HealthDTO();
    }
}
