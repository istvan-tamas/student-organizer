package com.studentorganizer.services;
import org.springframework.stereotype.Service;

import com.studentorganizer.models.DTO.HealthDTO;

@Service
public class HealthService {
    private HealthDTO health = new HealthDTO();
    public String returnStatus(){
        return health.toString();
    }
}
