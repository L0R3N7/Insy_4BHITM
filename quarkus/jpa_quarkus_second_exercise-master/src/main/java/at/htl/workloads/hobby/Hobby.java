package at.htl.workloads.hobby;

import at.htl.workloads.person.Person;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Entity
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Boolean outdoor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getOutdoor() {
        return outdoor;
    }

    public void setOutdoor(Boolean outdoor) {
        this.outdoor = outdoor;
    }

    public static Hobby create(String description, boolean outdoor){
        var newHobby = new Hobby();
        newHobby.setDescription(description);
        newHobby.setOutdoor(outdoor);
        return newHobby;
    }
}
