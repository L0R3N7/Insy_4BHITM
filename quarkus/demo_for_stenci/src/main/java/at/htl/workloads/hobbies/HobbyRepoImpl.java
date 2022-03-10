package at.htl.workloads.hobbies;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
public class HobbyRepoImpl implements HobbyRepo {

    private final EntityManager entityManager;

    public HobbyRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(Hobby hobby) {
        this.entityManager.persist(hobby);
    }

    @Override
    public Hobby getHobby(Long hobbyId) {
        TypedQuery<Hobby> query = this.entityManager
                .createQuery("select h from Hobby h where h.id = :id", Hobby.class);
        query.setParameter("id", hobbyId);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public Map<String, Long> getHobbyIsCount() {
         TypedQuery<CountResult> query = this.entityManager
                .createQuery("select NEW at.htl.workloads.hobbies.CountResult( h.description, count(p.id)) from Interest i " +
                        "join i.id.person p " + //("where foo in (:list)")
                        "join i.id.hobby h " +
                        "group by h.id", CountResult.class);
         return query.getResultStream().collect(Collectors.toMap(c -> c.desc(), c -> c.count()));
    }

}
