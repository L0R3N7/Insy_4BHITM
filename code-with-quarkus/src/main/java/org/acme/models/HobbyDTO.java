package org.acme.models;

public class HobbyDTO { //request //orika to map from dto to class
    private String description;
    private Boolean outdoor;

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
}
