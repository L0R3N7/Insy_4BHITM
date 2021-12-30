package at.htl.workloads.order;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Default
public class OrderrRepoImp implements OrderrRepo {

    private final EntityManager entityManager;

    public OrderrRepoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(Orderr orderr) {
        entityManager.persist(orderr);
    }
}
