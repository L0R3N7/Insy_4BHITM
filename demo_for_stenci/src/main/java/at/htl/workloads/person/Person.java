package at.htl.workloads.person;

import at.htl.workloads.address.Address;
import at.htl.workloads.hobbies.Hobby;

import javax.enterprise.inject.Default;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Boolean isAwesome = false;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToMany(mappedBy = "id.person", cascade = CascadeType.ALL)
    private List<Interest> interests = new ArrayList<>();

    @OneToMany(mappedBy = "person", cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();


    public void addHobby(Hobby hobby, boolean amateur) {
        var id = new InterestId();
        id.setPerson(this);
        id.setHobby(hobby);

        var interest = new Interest();
        interest.setId(id);
        interest.setAmateur(amateur);

        this.interests.add(interest);
    }


    public static Person create(String firstName, String lastName, LocalDate dateOfBirth, Gender gender, Boolean isAwesome) {
        var newPers = new Person();
        newPers.setLastName(lastName);
        newPers.setFirstName(firstName);
        newPers.setDateOfBirth(dateOfBirth);
        newPers.setGender(gender);
        newPers.setAwesome(isAwesome);
        return newPers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<Interest> getInterests() {
        return interests;
    }

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void addAddress(Address address) {
        address.setPerson(this);
        this.addresses.add(address);
    }

    public Boolean getAwesome() {
        return isAwesome;
    }

    public void setAwesome(Boolean awesome) {
        isAwesome = awesome;
    }
}
