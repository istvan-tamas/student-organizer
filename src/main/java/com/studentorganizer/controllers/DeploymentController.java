package com.studentorganizer.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.studentorganizer.services.DeployService;

@Controller
public class DeploymentController {

    InputStream inputStream = getClass().getResourceAsStream("/MOCK_DATA.csv");

    @GetMapping("/")
    public String deploy(Model model) throws FileNotFoundException, IOException{
        try{
            DeployService.start(inputStream);
        }
        catch(Exception e){
            System.out.println("Error: " + e);
        }   
        return "redirect:/students";
    }

}
