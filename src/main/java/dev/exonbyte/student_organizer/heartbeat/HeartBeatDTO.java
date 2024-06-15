package dev.exonbyte.student_organizer.heartbeat;

import java.util.Date;
import java.sql.Timestamp;
import java.util.UUID;

public class HeartBeatDTO {
    private String status;
    private Timestamp timestamp;
    private UUID uuid;

    public HeartBeatDTO(){

        Date date = new Date();

        this.status = "OK";
        this.timestamp = new Timestamp(date.getTime());
        this.uuid = UUID.randomUUID();
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }


    @Override
    public String toString() {
        return "{" +
                " status='" + getStatus() + "'" +
                ", timestamp='" + getTimestamp() + "'" +
                ", uuid='" + getUuid() + "'" +
                "}";
    }
}
