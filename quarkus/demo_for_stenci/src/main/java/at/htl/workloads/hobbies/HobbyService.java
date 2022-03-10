package at.htl.workloads.hobbies;

import java.util.Map;

public interface HobbyService {
    Hobby addHobby(String description, Boolean outdoor);

    Hobby getHobby(Long hobbyId);

    Map<String, Long> getHobbyIsCount();
}
