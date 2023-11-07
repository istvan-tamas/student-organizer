package com.studentorganizer.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DeployService {
    public void start() throws FileNotFoundException, IOException {
        String COMMA_DELIMITER = ";";

        List<List<String>> records = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\csv-db\\MOCK_DATA.csv"))){
        String line;
        while((line = br.readLine()) != null){
            String[] values = line.split(COMMA_DELIMITER);
            records.add(Arrays.asList(values));
        }
        }
        System.out.println("this is the deployment service");
        System.out.println(records);
    }
}