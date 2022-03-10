package org.acme.workloads.person;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Interest {

    @EmbeddedId
    private InterestId id;
    private Boolean amateur;

    public Interest() {
    }

    public InterestId getId() {
        return id;
    }

    public void setId(InterestId id) {
        this.id = id;
    }

    public Boolean getAmateur() {
        return amateur;
    }

    public void setAmateur(Boolean amateur) {
        this.amateur = amateur;
    }
}
