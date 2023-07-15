package com.studentorganizer.controllers;
import org.springframework.web.bind.annotation.RestController;
import com.studentorganizer.services.HealthService;

import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HealthController {

    @Autowired
    private HealthService healthService;

    @GetMapping("/health")
    public String status(String health, Model model){
        model.addAttribute("health", healthService.toString());
        return "health";
    }
}
