package org.acme.workloads.hobbies;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;

@ApplicationScoped
public class HobbyRepoImpl implements HobbyRepo {

    private final EntityManager entityManager;

    public HobbyRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(Hobby hobby) {
        entityManager.persist(hobby);
    }
}
