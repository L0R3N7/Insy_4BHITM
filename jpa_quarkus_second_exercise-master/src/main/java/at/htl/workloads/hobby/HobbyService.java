package at.htl.workloads.hobby;

import java.util.List;
import java.util.Map;

public interface HobbyService {
    Hobby addHobby(String description, Boolean outdoor);
    Hobby getHobby(Long hobbyId);
    Map<String, Long> getHobbyistCount();
    List<Object[]> theMostPopularItemPerHobby();
}
