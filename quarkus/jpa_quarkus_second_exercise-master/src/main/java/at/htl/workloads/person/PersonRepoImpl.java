package at.htl.workloads.person;

import at.htl.workloads.order.Orderr;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class PersonRepoImpl implements PersonRepo {

    private final EntityManager entityManager;

    public PersonRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Person> getAll() {
        TypedQuery<Person> query = this.entityManager
                .createQuery("select p from Person p",
                        Person.class);
        return query.getResultList();
    }

    @Override
    public Person getPerson(Long id) {
        TypedQuery<Person> query = this.entityManager
                .createQuery("select p from Person p where p.id = :id",
                        Person.class);
        query.setParameter("id", id);
        return query.getResultList().stream()
                .findFirst().orElse(null);
    }

    @Override
    public void update(Person person) {
        this.entityManager.merge(person); // update
    }

    @Override
    public void add(Person p) {
        this.entityManager.persist(p);
    }

    @Override
    public long numberOfOrders(long id) {
        TypedQuery<Long> query = this.entityManager
                .createQuery("select count(o) from Person p, Orderr o where p.id = :id and o.person = p", Long.class)
                .setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }
}
