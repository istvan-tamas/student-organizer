package com.studentorganizer.models.DTO;
import java.util.Objects;

public class StudentDTO {
    private String neptune;
    private String firstName;
    private String lastName;
    private String major;
    private String educationType;

    public StudentDTO() {
    }

    public StudentDTO(String neptune, String firstName, String lastName, String major, String educationType) {
        this.neptune = neptune;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.educationType = educationType;
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

    public StudentDTO neptune(String neptune) {
        setNeptune(neptune);
        return this;
    }

    public StudentDTO firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public StudentDTO lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public StudentDTO major(String major) {
        setMajor(major);
        return this;
    }

    public StudentDTO educationType(String educationType) {
        setEducationType(educationType);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof StudentDTO)) {
            return false;
        }
        StudentDTO studentDTO = (StudentDTO) o;
        return Objects.equals(neptune, studentDTO.neptune) && Objects.equals(firstName, studentDTO.firstName) && Objects.equals(lastName, studentDTO.lastName) && Objects.equals(major, studentDTO.major) && Objects.equals(educationType, studentDTO.educationType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(neptune, firstName, lastName, major, educationType);
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
