package com.studentorganizer.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentorganizer.services.DeployService;

@RestController
public class DeploymentController {
    

public static List<List<String>> records = new ArrayList<>();

    @GetMapping("/")
    public String deploy(Model model) throws FileNotFoundException, IOException{
        try{
            DeployService.start();
        }
        catch(Exception e){
            System.out.println("Error: " + e);
        }   
        return "deployment";
    }

}
