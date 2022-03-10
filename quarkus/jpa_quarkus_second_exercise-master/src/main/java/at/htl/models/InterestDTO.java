package at.htl.models;

public class InterestDTO {
    private Long hobbyId;
    private Boolean amateur;

    public InterestDTO() {
    }

    public Long getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(Long hobbyId) {
        this.hobbyId = hobbyId;
    }

    public Boolean getAmateur() {
        return amateur;
    }

    public void setAmateur(Boolean amateur) {
        this.amateur = amateur;
    }
}
