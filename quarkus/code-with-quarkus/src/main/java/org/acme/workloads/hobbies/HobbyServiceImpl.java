package org.acme.workloads.hobbies;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HobbyServiceImpl implements HobbyService{
    private final HobbyRepo hobbyRepo;

    @Override
    public Hobby addHobby(String description, Boolean outdoor) {
        var hobby = new Hobby();
        hobby.setDescription(description);
        hobby.setOutdoor(outdoor);
        this.hobbyRepo.add(hobby);
        return hobby;
    }
}
