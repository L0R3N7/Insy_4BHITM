package at.htl.workloads.hobbies;

public record CountResult(String desc, Long count){}


/*

public class CountResult {
    private Long count;
    private String description;

    public CountResult() {
    }

    public CountResult(String description, Long count) {
        this.count = count;
        this.description = description;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}*/
