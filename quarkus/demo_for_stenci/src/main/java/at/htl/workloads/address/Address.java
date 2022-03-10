package at.htl.workloads.address;

import at.htl.workloads.person.Person;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String street;
    int streetNr;
    int post;
    String city;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Address() {
    }

    public static Address create(String Street, int StreetNr, int Post, String city) {
        Address address = new Address();
        address.setStreet(Street);
        address.setStreetNr(StreetNr);
        address.setPost(Post);
        address.setCity(city);
        return address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNr() {
        return streetNr;
    }

    public void setStreetNr(int streetNr) {
        this.streetNr = streetNr;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
