package dev.exonbyte.student_organizer.heartbeat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartBeatController {

    @Autowired
    private HeartBeatService hbService;

    @GetMapping("/heartbeat")
    public String heartbeat(){
        return hbService.returnStatus();
    }
}
