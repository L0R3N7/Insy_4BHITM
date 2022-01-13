package at.htl.workloads.hobby;

import at.htl.result.ItemHobby;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
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

    @Override
    public List<ItemHobby> theMostPopularItemPerHobby() {
        return hobbyRepo.theMostPopularItemPerHobby();
    }
}
