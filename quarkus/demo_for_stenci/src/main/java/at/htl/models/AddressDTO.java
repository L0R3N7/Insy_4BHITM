package at.htl.models;

import java.io.Serializable;
import java.util.Objects;

public class AddressDTO implements Serializable {
    private String street;
    private int streetNr;
    private int post;
    private String city;

    public AddressDTO(String street, int streetNr, int post, String city) {
        this.street = street;
        this.streetNr = streetNr;
        this.post = post;
        this.city = city;
    }
    public AddressDTO(){}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDTO entity = (AddressDTO) o;
        return Objects.equals(this.street, entity.street) &&
                Objects.equals(this.streetNr, entity.streetNr) &&
                Objects.equals(this.post, entity.post) &&
                Objects.equals(this.city, entity.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, streetNr, post, city);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "street = " + street + ", " +
                "streetNr = " + streetNr + ", " +
                "post = " + post + ", " +
                "city = " + city + ")";
    }
}
