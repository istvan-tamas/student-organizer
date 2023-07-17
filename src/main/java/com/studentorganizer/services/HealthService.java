package com.studentorganizer.services;
import org.springframework.stereotype.Service;

import com.studentorganizer.models.DTO.HealthDTO;

@Service
public class HealthService {
    public String returnStatus(){
        HealthDTO health = new HealthDTO();
        return health.toString();
    }
}
