package at.htl.workloads.hobbies;

import java.util.Map;

public interface HobbyRepo {
    void add(Hobby hobby);

    Hobby getHobby(Long hobbyId);

    Map<String, Long> getHobbyIsCount();
}
