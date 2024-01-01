package com.studentorganizer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.studentorganizer.models.Student;
import com.studentorganizer.models.DTO.StudentDTO;
import com.studentorganizer.services.StudentService;

import java.util.Optional;


@Controller
public class StudenController {
    
    @Autowired
    private StudentService studentService;


    @RequestMapping("/students")
    public String showAll(Model model){
        model.addAttribute("students", studentService.findAll());
        return "students";
    }
 
    @GetMapping("/new-student")
    public String showNewStudentform(Model model, StudentDTO student){
        model.addAttribute("student", student);
        return "new-student";
    }

    @PostMapping("/new-student")
    public String addStudent(Model model, StudentDTO student){
        model.addAttribute("student", student);
        studentService.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/update-student/{id}")
    public String showUpdateStudent(Model model, Student student, @PathVariable String id){
        model.addAttribute("student", studentService.getStudentbyId(id));
        return "update-student" ;
    }

   @PostMapping("/update-student")
    public String updateStudent(Model model, Student student){
        model.addAttribute("student", student);  
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/delete-student/{id}")
    public String deleteStudent(Model model, @PathVariable String id, StudentDTO student){
        model.addAttribute("student", student);
        studentService.deleteStudent(id);
        return "redirect:/students";
    }


    @RequestMapping(value = "/list-students", method = RequestMethod.GET)
    public String listStudents(
                Model model,
                @RequestParam("page") Optional<Integer> page,
                @RequestParam("size") Optional<Integer> size) {
            int currentPage = page.orElse(1);
            int pageSize = size.orElse(5);

            Page<Student> studentPage = studentService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

            model.addAttribute("bookPage");

            int totalPages = studentPage.getTotalPages();
            if (totalPages > 0) {
                List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                        .boxed()
                        .collect(Collectors.toList());
                model.addAttribute("pageNumbers", studentNumbers);
            }

            return "list-students.html";
        }

}