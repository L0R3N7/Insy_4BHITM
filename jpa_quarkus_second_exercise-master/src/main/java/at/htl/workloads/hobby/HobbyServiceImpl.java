package at.htl.workloads.hobby;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import java.util.Map;

@ApplicationScoped
public class HobbyServiceImpl implements HobbyService {

    private final HobbyRepo hobbyRepo;

    public HobbyServiceImpl(HobbyRepo hobbyRepo) {
        this.hobbyRepo = hobbyRepo;
    }

    @Override
    public Hobby addHobby(String description, Boolean outdoor) {
        var hobby = Hobby.create(description, outdoor);
        this.hobbyRepo.add(hobby);
        return hobby;
    }

    @Override
    public Hobby getHobby(Long hobbyId) {
        return this.hobbyRepo.getHobby(hobbyId);
    }

    @Override
    public Map<String, Long> getHobbyistCount() {
        return this.hobbyRepo.getHobbyistCount();
    }
}
