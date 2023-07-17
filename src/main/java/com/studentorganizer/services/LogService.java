package com.studentorganizer.services;

import java.sql.Timestamp;
import java.util.UUID;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class LogService {
    public void log(){
        Date date = new Date();
        System.out.println(new Timestamp(date.getTime()));
        System.out.println(UUID.randomUUID());
        System.out.println("some log message");
    }
}
