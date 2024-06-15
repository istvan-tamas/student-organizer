package dev.exonbyte.student_organizer.heartbeat;

import org.springframework.stereotype.Service;

@Service
public class HeartBeatService {
    public String returnStatus() {
        HeartBeatDTO hb = new HeartBeatDTO();
        return hb.toString();
    }
}
