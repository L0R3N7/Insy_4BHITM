package at.htl.workloads.hobby;

import at.htl.result.ItemHobby;

import java.util.List;
import java.util.Map;

public interface HobbyService {
    Hobby addHobby(String description, Boolean outdoor);
    Hobby getHobby(Long hobbyId);
    Map<String, Long> getHobbyistCount();
    List<ItemHobby> theMostPopularItemPerHobby();
}
