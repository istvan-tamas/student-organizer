package com.studentorganizer.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentorganizer.services.DeployService;

@RestController
public class DeploymentController {

    @Autowired
    private DeployService deployService;

    @GetMapping("/")
    public String deploy(Model model) throws FileNotFoundException, IOException{
        try{
            deployService.start();
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return "deployment";
    }

}
