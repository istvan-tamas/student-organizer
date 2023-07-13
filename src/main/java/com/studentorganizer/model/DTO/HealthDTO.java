package com.studentorganizer.model.DTO;

import java.util.Date;
import java.sql.Timestamp;
import java.util.UUID;

public class HealthDTO {
    private String status;
    private Timestamp timestamp;
    private UUID uuid;


    public HealthDTO(){
        // get date for timestamp
        Date date = new Date();

        this.status = "OK";
        this.timestamp = new Timestamp(date.getTime());
        this.uuid = UUID.randomUUID();
    }

    
}