package com.studentorganizer.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import com.studentorganizer.models.Student;

public class DeployService {

    public void start() throws IOException {
    ArrayList<Student> students = new ArrayList<Student>(); 
    try (BufferedReader br = new BufferedReader(new FileReader("../../resources/csv-db/MOCK_DATA.csv"))) {    
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Student student = new Student(values[0], values[1], values[2],values[3],values[4],UUID.randomUUID().toString());
                students.add(student);
        }
    } catch (Exception e) {
        System.out.println("Could not read input file");
    }
    }
}