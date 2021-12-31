package at.htl.workloads.hobby;

import java.util.List;
import java.util.Map;

public interface HobbyRepo {
    void add(Hobby hobby);
    Hobby getHobby(Long hobbyId);
    Map<String, Long> getHobbyistCount();

    List<Object[]> theMostPopularItemPerHobby();
}
