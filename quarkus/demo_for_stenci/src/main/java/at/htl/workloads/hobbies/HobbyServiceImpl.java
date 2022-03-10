package at.htl.workloads.hobbies;

import javax.enterprise.context.ApplicationScoped;
import java.util.Map;

@ApplicationScoped
public class HobbyServiceImpl implements HobbyService {

    private final HobbyRepo hobbyRepo;

    public HobbyServiceImpl(HobbyRepo hobbyRepo) {
        this.hobbyRepo = hobbyRepo;
    }

    @Override
    public Hobby addHobby(String description, Boolean outdoor) {
        var hobby = new Hobby();
        hobby.setDescription(description);
        hobby.setOutdoor(outdoor);
        this.hobbyRepo.add(hobby);
        return hobby;
    }

    @Override
    public Hobby getHobby(Long hobbyId) {
        return this.hobbyRepo.getHobby(hobbyId);
    }

    @Override
    public Map<String, Long> getHobbyIsCount() {
        return this.hobbyRepo.getHobbyIsCount();
    }
}
