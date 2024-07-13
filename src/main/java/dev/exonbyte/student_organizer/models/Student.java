package dev.exonbyte.student_organizer.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student extends AbstractStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String neptune;
    private String firstName;
    private String lastName;
    private String major;
    private String educationType;
    private String uuid;

    public Student(String neptune, String firstName, String lastName, String major, String educationType, String uuid) {
        this.neptune = neptune;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.educationType = educationType;
        this.uuid = uuid;
    }
}

