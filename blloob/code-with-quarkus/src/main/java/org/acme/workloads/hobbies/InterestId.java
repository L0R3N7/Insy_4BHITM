package org.acme.workloads.hobbies;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class InterestId implements Serializable {

    @ManyToOne
    private Person person;
    @ManyToOne
    private Hobby hobby;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InterestId that = (InterestId) o;
        return person.equals(that.person) && hobby.equals(that.hobby);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, hobby);
    }
}
