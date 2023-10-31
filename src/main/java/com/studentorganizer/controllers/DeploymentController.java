package com.studentorganizer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.studentorganizer.services.DeployService;

public class DeploymentController {

    @Autowired
    private DeployService deployService;

    @GetMapping("/")
    public String deploy(){
        deployService.start().toString();
    }
}
