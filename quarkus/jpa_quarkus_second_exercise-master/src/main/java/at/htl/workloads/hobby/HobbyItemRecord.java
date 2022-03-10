package at.htl.workloads.hobby;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record HobbyItemRecord(
        Long hobbyId,
        Long itemNo
){} /*implements Serializable {
    @JsonCreator
    public HobbyItemRecord(
            @JsonProperty("hobbyName") String hobbyName,
            @JsonProperty("itemNo") String itemNo
    ){
        this(
                hobbyName,
                longValue(itemNo)
        );
    }

    private static Long longValue(String string) {
        return Long.parseLong(string);
    }
}*/
