package at.htl.workloads.address;

import at.htl.workloads.person.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class AddressRepoImpl implements AddressRepo{

    private final EntityManager entityManager;

    public AddressRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(Address address) {
        address.toString();
        entityManager.persist(address);
    }

    @Override
    public Address getAddress(long aid) {
        TypedQuery<Address> query = this.entityManager
                .createQuery("select a from Address a where a.id = :id",
                        Address.class);
        query.setParameter("id", aid);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public List<String> getAllCities() {
        TypedQuery<String> query = this.entityManager
                .createQuery("select a.city from Address a", String.class);
        return query.getResultStream().collect(Collectors.toList());
    }
}
