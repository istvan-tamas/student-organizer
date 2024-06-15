package dev.exonbyte.student_organizer.deployment;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeploymentController {

    @GetMapping("/")
    public String deploy(Model model) throws FileNotFoundException, IOException{
        try{
            DeploymentService.start();
        }
        catch(Exception e){
            System.out.println("Error: " + e);
        }
        return "redirect:/students";
    }

}

