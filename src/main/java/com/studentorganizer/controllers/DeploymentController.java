package com.studentorganizer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentorganizer.services.DeployService;

@RestController
public class DeploymentController {

    @Autowired
    private DeployService deployService;

    @GetMapping("/deploy")
    public String deploy(Model model){
        deployService.start();
        return "deployment";
    }

}
