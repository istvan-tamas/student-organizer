package com.studentorganizer.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.studentorganizer.models.Student;

@Service
public class DeployService {
    public static List<Student> records = new ArrayList<>();
    public static void start() throws FileNotFoundException, IOException {
        String COMMA_DELIMITER = ",";
        try(BufferedReader br = new BufferedReader(new FileReader("student-organizer/src/main/resources/csv-db/MOCK_DATA.csv"))){
            String line;
                while((line = br.readLine()) != null){
                String[] values = line.split(COMMA_DELIMITER);
                records.add(new Student(values[0], values[1], values[2],values[3],values[4],UUID.randomUUID().toString()));
            }
        }
    }
}