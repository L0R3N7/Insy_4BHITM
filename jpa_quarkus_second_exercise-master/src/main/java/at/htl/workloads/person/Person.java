package at.htl.workloads.person;

import at.htl.workloads.hobby.Hobby;
import at.htl.workloads.order.Orderr;

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
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToMany(mappedBy = "id.person", cascade = CascadeType.ALL)
    private List<Interest> interests = new ArrayList<>();
    @OneToMany(mappedBy = "person", cascade = CascadeType.REFRESH)
    private List<Orderr> orderrs = new ArrayList<>();

    public Person() {
    }

    public void addInterest(Hobby hobby, boolean amateur) {
        var id = new InterestId();
        id.setPerson(this);
        id.setHobby(hobby);

        var interest = new Interest();
        interest.setId(id);
        interest.setAmateur(amateur);

        this.interests.add(interest);
    }

    public List<Orderr> getOrderrs() {
        return orderrs;
    }

    public void setOrderrs(List<Orderr> orderrs) {
        this.orderrs = orderrs;
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
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

    public void addOrderrs(Orderr orderr){
        this.orderrs.add(orderr);
    }

    public static Person create(String firstName, String lastName, LocalDate dateOfBirth, Gender gender) {
        var newPers = new Person();
        newPers.setLastName(lastName);
        newPers.setFirstName(firstName);
        newPers.setDateOfBirth(dateOfBirth);
        newPers.setGender(gender);
        return newPers;
    }
}
