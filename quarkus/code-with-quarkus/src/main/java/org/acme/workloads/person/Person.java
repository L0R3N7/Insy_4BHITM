package org.acme.workloads.person;
import org.acme.workloads.hobbies.Hobby;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firsName;
    private String lastName;
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "person.id", cascade = CascadeType.ALL)
    private List<Interest> interestList = new ArrayList<>();

    public void addHobby(Hobby hobby, Boolean amateur){
        var id = new InterestId();
        id.setHobby(hobby);
        id.setPerson(this);

        var interest = new Interest();
        interest.setId(id);
        interest.setAmateur(amateur);

        this.interestList.add(interest);
    }

    /*public void removeHobby(Hobby hobby){

        hobby.setPerson(null);
        this.hobbyList.remove(hobby);
    }*/

    public List<Hobby> getHobbyList() {
        return hobbyList;
    }

    public void setHobbyList(List<Hobby> hobbyList) {
        this.hobbyList = hobbyList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
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

    public static Person create(String firsName, String lastName, LocalDate dateOfBirth, Gender gender){
        var newPers = new Person();
        newPers.setFirsName(firsName);
        newPers.setLastName(lastName);
        newPers.setGender(gender);
        newPers.setDateOfBirth(dateOfBirth);
        return newPers;
    }
}
