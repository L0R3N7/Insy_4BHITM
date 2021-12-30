package at.htl.workloads.order.logic;

import at.htl.workloads.order.Orderr;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@ApplicationScoped
public class OrderrRepoImp implements OrderrRepo {

    private final EntityManager entityManager;

    public OrderrRepoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(Orderr orderr) {
        entityManager.persist(orderr);
    }

    @Override
    public void update(Orderr orderr) {entityManager.persist(orderr);}

    @Override
    public Orderr get(long id) {
        TypedQuery<Orderr> query= entityManager
                .createQuery("select o from Orderr o where o.orderNo = :id", Orderr.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public boolean deleteOrder(long id) {
        int response = entityManager
                .createQuery("delete from Orderr o where o.orderNo = :id")
                .setParameter("id", id)
                .executeUpdate();
        return response == 1;
    }
}