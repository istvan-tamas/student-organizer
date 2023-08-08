package com.studentorganizer.models;

public class Student {

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

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

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
}
