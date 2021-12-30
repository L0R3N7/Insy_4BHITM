package at.htl.workloads.person;

import at.htl.workloads.hobbies.Hobby;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class InterestId implements Serializable {

    @JsonbTransient //Ausgabe bei der RestApi, keine Rekursion
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
