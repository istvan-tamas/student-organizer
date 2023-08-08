package com.studentorganizer.models.DTO;

import com.studentorganizer.models.abs.AbstractStudent;

public class StudentDTO extends AbstractStudent {


    private String neptune;
    private String firstName;
    private String lastName;
    private String major;
    private String educationType;

    public String getNeptune() {
        return this.neptune;
    }

    public void setNeptune(String neptune) {
        this.neptune = neptune;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMajor() {
        return this.major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEducationType() {
        return this.educationType;
    }

    public void setEducationType(String educationType) {
        this.educationType = educationType;
    }

    public StudentDTO(String neptune, String firstName, String lastName, String major, String educationType) {
        this.neptune = neptune;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.educationType = educationType;
    }

    @Override
    public String toString() {
        return "{" +
            " neptune='" + getNeptune() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", major='" + getMajor() + "'" +
            ", educationType='" + getEducationType() + "'" +
            "}";
    }
    
}
