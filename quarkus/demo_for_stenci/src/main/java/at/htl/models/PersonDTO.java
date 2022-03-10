package at.htl.models;

import at.htl.workloads.person.Gender;

import java.time.LocalDate;

public class PersonDTO {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private Boolean isAwesome;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Boolean getAwesome() {
        return isAwesome;
    }

    public void setAwesome(Boolean awesome) {
        isAwesome = awesome;
    }
}
